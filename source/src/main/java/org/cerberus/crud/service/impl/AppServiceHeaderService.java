/*
 * Cerberus  Copyright (C) 2013  vertigo17
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.crud.service.impl;

import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.cerberus.crud.dao.IAppServiceHeaderDAO;

import org.cerberus.crud.entity.AppServiceHeader;
import org.cerberus.crud.service.IAppServiceHeaderService;
import org.cerberus.engine.entity.MessageGeneral;
import org.cerberus.enums.MessageEventEnum;
import org.cerberus.enums.MessageGeneralEnum;
import org.cerberus.exception.CerberusException;
import org.cerberus.util.answer.Answer;
import org.cerberus.util.answer.AnswerItem;
import org.cerberus.util.answer.AnswerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bcivel
 */
@Service
public class AppServiceHeaderService implements IAppServiceHeaderService {

    @Autowired
    private IAppServiceHeaderDAO AppServiceHeaderDAO;

    private static final Logger LOG = Logger.getLogger(AppServiceHeaderService.class);

    private final String OBJECT_NAME = "Service Header";

    @Override
    public AnswerItem readByKey(String service, String key) {
        return AppServiceHeaderDAO.readByKey(service, key);
    }

    @Override
    public AnswerList readAll() {
        return readByVariousByCriteria(null, null, 0, 0, "sort", "asc", null, null);
    }

    @Override
    public AnswerList readByVarious(String service, String active) {
        return AppServiceHeaderDAO.readByVariousByCriteria(service, active, 0, 0, "sort", "asc", null, null);
    }

    @Override
    public AnswerList readByCriteria(int startPosition, int length, String columnName, String sort, String searchParameter, Map<String, List<String>> individualSearch) {
        return AppServiceHeaderDAO.readByVariousByCriteria(null, null, startPosition, length, columnName, sort, searchParameter, individualSearch);
    }

    @Override
    public AnswerList readByVariousByCriteria(String service, String active, int startPosition, int length, String columnName, String sort, String searchParameter, Map<String, List<String>> individualSearch) {
        return AppServiceHeaderDAO.readByVariousByCriteria(service, active, startPosition, length, columnName, sort, searchParameter, individualSearch);
    }

    @Override
    public boolean exist(String service, String key) {
        AnswerItem objectAnswer = readByKey(service, key);
        return (objectAnswer.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) && (objectAnswer.getItem() != null); // Call was successfull and object was found.
    }

    @Override
    public Answer create(AppServiceHeader object) {
        return AppServiceHeaderDAO.create(object);
    }

    @Override
    public Answer delete(AppServiceHeader object) {
        return AppServiceHeaderDAO.delete(object);
    }

    @Override
    public Answer update(AppServiceHeader object) {
        return AppServiceHeaderDAO.update(object);
    }

    @Override
    public AppServiceHeader convert(AnswerItem answerItem) throws CerberusException {
        if (answerItem.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return (AppServiceHeader) answerItem.getItem();
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

    @Override
    public List<AppServiceHeader> convert(AnswerList answerList) throws CerberusException {
        if (answerList.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return (List<AppServiceHeader>) answerList.getDataList();
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

    @Override
    public void convert(Answer answer) throws CerberusException {
        if (answer.isCodeEquals(MessageEventEnum.DATA_OPERATION_OK.getCode())) {
            //if the service returns an OK message then we can get the item
            return;
        }
        throw new CerberusException(new MessageGeneral(MessageGeneralEnum.DATA_OPERATION_ERROR));
    }

    @Override
    public AnswerList<String> readDistinctValuesByCriteria(String service, String searchParameter, Map<String, List<String>> individualSearch, String columnName) {
        return AppServiceHeaderDAO.readDistinctValuesByCriteria(service, searchParameter, individualSearch, columnName);
    }

}
