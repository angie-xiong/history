package com.antaina.service.order;

import com.antaina.entity.order.OrderDeliveryDetail;
import com.antaina.entity.order.OrderInfo;
import com.antaina.enums.MsgResult;
import com.antaina.exception.BusinessException;
import com.antaina.mapper.OrderDeliveryDetailMapper;
import com.antaina.mapper.OrderInfoMapper;
import com.antaina.model.order.OrderDeliveryDetailModel;
import com.antaina.util.UidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class OrderDeliveryDetailService {

    @Autowired
    private OrderDeliveryDetailMapper orderDeliveryDetailMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public List<OrderDeliveryDetail> getDeliveryListByOrderId(Long orderId) {
        OrderDeliveryDetail condition = new OrderDeliveryDetail();
        condition.setOrderId(orderId);
        return orderDeliveryDetailMapper.select(condition);
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(OrderDeliveryDetailModel orderDeliveryDetailModel) {
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orderDeliveryDetailModel.getOrderId());
        if (null == orderInfo) {
            throw new BusinessException(MsgResult.ORDER_EXIST_NO);
        }
        orderInfo.setDeliveryAmount(orderInfo.getDeliveryAmount().add(orderDeliveryDetailModel.getAmount()));
        orderInfo.setRemainingAmount(orderInfo.getAmount().subtract(orderDeliveryDetailModel.getAmount()));

        OrderDeliveryDetail odd = new OrderDeliveryDetail();
        BeanUtils.copyProperties(orderDeliveryDetailModel, odd);
        odd.setId(UidUtil.getInstance().nextId());
        odd.setCreateTime(new Date());
        odd.setUpdateTime(new Date());

        orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
        orderDeliveryDetailMapper.insert(odd);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long deliveryId) {
        OrderDeliveryDetail odd = orderDeliveryDetailMapper.selectByPrimaryKey(deliveryId);
        if (null == odd) {
            throw new BusinessException(MsgResult.DELIVERY_EXIST_NO);
        }
        OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(odd.getOrderId());
        if (null == orderInfo) {
            throw new BusinessException(MsgResult.ORDER_EXIST_NO);
        }
        orderInfo.setDeliveryAmount(orderInfo.getDeliveryAmount().subtract(odd.getAmount()));
        orderInfo.setRemainingAmount(orderInfo.getRemainingAmount().add(odd.getAmount()));
        orderInfo.setUpdateTime(new Date());
        int affectedRows = orderInfoMapper.updateByPrimaryKeySelective(orderInfo);
        if (1 == affectedRows) {
            orderDeliveryDetailMapper.deleteByPrimaryKey(deliveryId);
            log.info("删除出货记录成功，未交货数量已重新计算");
        }
    }
}
