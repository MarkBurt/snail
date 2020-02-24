package com.mark.model.mappers.admin;

import com.mark.model.admin.pojos.AdChannelLabel;

/**
 * @author MAIBENBEN
 */
public interface AdChannelLabelMapper {

    /**
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int insert(AdChannelLabel record);

    /**
     *
     * @param record
     * @return
     */
    int insertSelective(AdChannelLabel record);

    /**
     *
     * @param id
     * @return
     */
    AdChannelLabel selectByPrimaryKey(Integer id);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(AdChannelLabel record);

    /**
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(AdChannelLabel record);

    /**
     * 根据labelId查询
     * @param id
     * @return
     */
    AdChannelLabel selectByLabelId(Integer id);
}