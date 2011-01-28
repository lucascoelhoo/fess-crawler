/*
 * Copyright 2004-2011 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.robot.dbflute.s2dao.metadata.impl;

import java.sql.DatabaseMetaData;

import org.seasar.robot.dbflute.s2dao.metadata.TnBeanAnnotationReader;
import org.seasar.robot.dbflute.s2dao.metadata.TnBeanMetaDataFactory;
import org.seasar.robot.dbflute.s2dao.metadata.TnRelationPropertyTypeFactory;
import org.seasar.robot.dbflute.s2dao.metadata.TnRelationPropertyTypeFactoryBuilder;

/**
 * {Created with reference to S2Container's utility and extended for DBFlute}
 * @author jflute
 */
public class TnRelationPropertyTypeFactoryBuilderImpl implements TnRelationPropertyTypeFactoryBuilder {

    protected TnBeanMetaDataFactory beanMetaDataFactory;

    public void setBeanMetaDataFactory(TnBeanMetaDataFactory beanMetaDataFactory) {
        this.beanMetaDataFactory = beanMetaDataFactory;
    }

    public TnRelationPropertyTypeFactory build(Class<?> beanClass, TnBeanAnnotationReader beanAnnotationReader,
            DatabaseMetaData databaseMetaData, int relationNestLevel, boolean isStopRelationCreation) {
        return new TnRelationPropertyTypeFactoryImpl(beanClass, beanAnnotationReader, beanMetaDataFactory,
                databaseMetaData, relationNestLevel, isStopRelationCreation);
    }
}
