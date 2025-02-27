#include <omp.h>        //Use OpenMP
#include <stdio.h>      //Provide I/O
#include <stdlib.h>     //Use NULL
#include <unistd.h>     //Use usleep (sleep for a number of microseconds)

//====================================使用OpenMP的simple binary semaphores实现哲学家就餐问题====================================

#define NUM_PHIL 5      //The number of philosophers
#define MEALS 100        //The number of meals per philosopher

static omp_lock_t chopsticks[NUM_PHIL];   //Locks to represent chopsticks,一个二进制锁

/*  This function represents the philosopher threads.  Each philosopher must
 *  wait until all others have started before continuing.  Each then eats NUM_PHIL
 *  meals.  Philosophers must acquire chopsticks to their left and right before eating.
 */
void philosopher()
{
  //Wait for all threads to start
  #pragma omp barrier

  //Set up variables for the thread id, right chopstick, and left chopstick.
  int id = omp_get_thread_num();
  int right_chopstick;
  int left_chopstick;

  //Philosophers 0 through NUM_PHIL-2 reach to the left first then the right.
  if(id < NUM_PHIL -1)
  {
    right_chopstick = id;
    left_chopstick = id+1;
  }
  //Philosopher NUM_PHIL-1 has its left and right swapped.  Notice that it reaches in the
  //opposite order of all other philosophers.
  else
  {
    right_chopstick = 0;
    left_chopstick = id;
  }

  //Acquire chopsticks (semaphores), eat, wait for 100 microseconds, then release chopsticks (semaphores).
  int i;
  
  while(true)
  {
    // 这么做的原理：规定奇数号的哲学家先拿起他左边的筷子,然后再去拿他右边的筷子;而偶数号 
    //的哲学家则相反.按此规定,将是1,2号哲学家竞争1号筷子,3,4号哲学家竞争3号筷子.即 
    //五个哲学家都竞争奇数号筷子,获得后,再去竞争偶数号筷子,最后总会有一个哲学家能获 
    //得两支筷子而进餐。而申请不到的哲学家进入阻塞等待队列，根FIFO原则，则先申请的哲 
    //学家会较先可以吃饭，因此不会出现饿死的哲学家。
    if(NUM_PHIL%2==0)
    {
       // 只有同时都获取到左手和右手边的筷子时，才开始吃：防止进程被饿死（饥饿现象）
      if(omp_test_lock(&chopsticks[right_chopstick]))
      {
        if(omp_test_lock(&chopsticks[left_chopstick]))
        {
          printf("philosopher %d is eating\n", id);
          usleep(100);
          omp_unset_lock(&chopsticks[left_chopstick]);
          omp_unset_lock(&chopsticks[right_chopstick]);
        }
        else  //当只获取了右手边的筷子时，释放右手边的筷子，主动让出资源
        {
          omp_unset_lock(&chopsticks[right_chopstick]);
        }
      }
    }
    else
    {
      if(omp_test_lock(&chopsticks[left_chopstick]))
      {
        if(omp_test_lock(&chopsticks[right_chopstick]))
        {
          printf("philosopher %d is eating\n", id);
          usleep(100);
          omp_unset_lock(&chopsticks[left_chopstick]);
          omp_unset_lock(&chopsticks[right_chopstick]);
        }
        else
        {
          omp_unset_lock(&chopsticks[left_chopstick]);
        }
      }
    }
  }
  
}

//Main function.
int main(int argc, char ** argv)
{
  int i;

  //Initialize locks
  for(i = 0; i < NUM_PHIL; i++)
    omp_init_lock(&chopsticks[i]);

  //Create and start philosopher threads.
  #pragma omp parallel num_threads(NUM_PHIL)
  {
    philosopher();
  }

  //Wait for philosophers to finish then destroy locks.
  for(i = 0; i < NUM_PHIL; i++)
    omp_destroy_lock(&chopsticks[i]);

  //End program.
  return 0;
}
