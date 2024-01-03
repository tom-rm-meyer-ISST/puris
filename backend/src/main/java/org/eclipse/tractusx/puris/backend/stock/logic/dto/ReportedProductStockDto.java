/*
 * Copyright (c) 2023 Volkswagen AG
 * Copyright (c) 2023 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.eclipse.tractusx.puris.backend.stock.logic.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.eclipse.tractusx.puris.backend.masterdata.logic.dto.MaterialDto;
import org.eclipse.tractusx.puris.backend.masterdata.logic.dto.PartnerDto;
import org.eclipse.tractusx.puris.backend.stock.domain.model.datatype.DT_StockTypeEnum;
import org.eclipse.tractusx.puris.backend.stock.logic.dto.itemstocksamm.ItemUnitEnumeration;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReportedProductStockDto extends StockDto {

    public ReportedProductStockDto(MaterialDto material, double quantity, ItemUnitEnumeration measurementUnit, String stockLocationBpns,
                                   String stockLocationBpna, PartnerDto partner, Date lastUpdatedOn, boolean isBlocked) {
        super(material, quantity, measurementUnit, stockLocationBpns, stockLocationBpna, lastUpdatedOn, partner, isBlocked);
        this.setType(DT_StockTypeEnum.PRODUCT);
    }

    public ReportedProductStockDto(MaterialDto material, double quantity, ItemUnitEnumeration measurementUnit, String stockLocationBpns, String stockLocationBpna, String customerOrderNumber, String customerOrderPositionNumber, String supplierOrderNumber, Date lastUpdatedOn, PartnerDto partner, boolean isBlocked) {
        super(material, quantity, measurementUnit, stockLocationBpns, stockLocationBpna, customerOrderNumber, customerOrderPositionNumber, supplierOrderNumber, lastUpdatedOn, partner, isBlocked);
        this.setType(DT_StockTypeEnum.PRODUCT);
    }
}
