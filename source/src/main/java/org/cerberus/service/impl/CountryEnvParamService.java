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
package org.cerberus.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.cerberus.dao.ICountryEnvParamDAO;
import org.cerberus.entity.CountryEnvParam;
import org.cerberus.entity.CountryEnvironmentApplication;
import org.cerberus.exception.CerberusException;
import org.cerberus.factory.IFactoryCountryEnvParam;
import org.cerberus.factory.IFactoryCountryEnvironmentApplication;
import org.cerberus.service.ICountryEnvParamService;
import org.cerberus.service.ICountryEnvironmentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bcivel
 */
@Service
public class CountryEnvParamService implements ICountryEnvParamService {

    @Autowired
    ICountryEnvParamDAO countryEnvParamDao;
    @Autowired
    IFactoryCountryEnvParam countryEnvParamFactory;
    @Autowired
    IFactoryCountryEnvironmentApplication countryEnvironmentApplicationFactory;
    @Autowired
    ICountryEnvironmentApplicationService countryEnvironmentApplicationService;

    @Override
    public CountryEnvParam findCountryEnvParamByKey(String system, String country, String environment) throws CerberusException {
        return countryEnvParamDao.findCountryEnvParamByKey(system, country, environment);
    }

    @Override
    public List<CountryEnvParam> findCountryEnvParamByCriteria(CountryEnvParam countryEnvParam) throws CerberusException {
        return countryEnvParamDao.findCountryEnvParamByCriteria(countryEnvParam);
        
    }

    @Override
    public List<CountryEnvParam> findActiveEnvironmentBySystemCountryApplication(String system, String country, String application) throws CerberusException {
        List<CountryEnvParam> result = new ArrayList();
        CountryEnvParam countryEnvParam = countryEnvParamFactory.create(system, country, true);
        CountryEnvironmentApplication countryEnvironmentApplication = countryEnvironmentApplicationFactory.create(system, country, null, application, null, null, null);

        List<CountryEnvironmentApplication> ceaList = countryEnvironmentApplicationService.findCountryEnvironmentApplicationByCriteria(countryEnvironmentApplication);
        List<CountryEnvParam> ceList = this.findCountryEnvParamByCriteria(countryEnvParam);

        for (CountryEnvironmentApplication cea : ceaList) {
            for (CountryEnvParam ce : ceList) {
                if (cea.getEnvironment().equals(ce.getEnvironment())) {
                    result.add(ce);
                }
            }
        }
        return result;
    }
}
