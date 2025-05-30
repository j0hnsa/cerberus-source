/**
 * Cerberus Copyright (C) 2013 - 2025 cerberustesting
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
package org.cerberus.core.crud.factory.impl;

import org.cerberus.core.crud.entity.TestDataLibData;
import org.cerberus.core.crud.factory.IFactoryTestDataLibData;
import org.springframework.stereotype.Service;

/**
 *
 * @author vertigo17
 */
@Service
public class FactoryTestDataLibData implements IFactoryTestDataLibData {

    @Override
    public TestDataLibData create(Integer testDataLibDataID, Integer testDataLibID, String subData, String encrypt, String value, String column,
            String parsingAnswer, String columnPosition, String description) {
        TestDataLibData newData = new TestDataLibData();
        newData.setTestDataLibDataID(testDataLibDataID);
        newData.setTestDataLibID(testDataLibID);
        newData.setSubData(subData);
        newData.setEncrypt(encrypt);
        newData.setValue(value);
        newData.setColumn(column);
        newData.setParsingAnswer(parsingAnswer);
        newData.setColumnPosition(columnPosition);
        newData.setDescription(description);
        return newData;
    }
}
