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
package org.cerberus.crud.factory;

import java.sql.Timestamp;
import org.cerberus.crud.entity.AppServiceContent;

/**
 * @author vertigo
 */
public interface IFactoryAppServiceContent {

    /**
     *
     * @param service
     * @param key
     * @param description Description.
     * @param value
     * @param active
     * @param sort
     * @param usrCreated
     * @param dateCreated
     * @param usrModif
     * @param dateModif
     * @return
     */
    AppServiceContent create(String service, String key,
            String value, String active, int sort, String description,
            String usrCreated, Timestamp dateCreated, String usrModif, Timestamp dateModif);

    /**
     *
     * @param service
     * @return
     */
    AppServiceContent create(String service);

}
