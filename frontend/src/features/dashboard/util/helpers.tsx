/*
Copyright (c) 2024 Volkswagen AG
Copyright (c) 2024 Contributors to the Eclipse Foundation

See the NOTICE file(s) distributed with this work for additional
information regarding copyright ownership.

This program and the accompanying materials are made available under the
terms of the Apache License, Version 2.0 which is available at
https://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.

SPDX-License-Identifier: Apache-2.0
*/
import { Box, Button } from '@mui/material';

export const createDateColumnHeaders = (numberOfDays: number) => {
    return Object.keys(Array.from({ length: numberOfDays })).map((_, index) => {
        const date = new Date();
        date.setDate(date.getDate() + index);
        return {
            field: `${index}`,
            headerName: date.toLocaleDateString('en-US', { weekday: 'long', day: '2-digit', month: '2-digit', year: 'numeric' }),
            headerAlign: 'center' as const,
            sortable: false,
            disableColumnMenu: true,
            width: 180,
            renderCell: (data: { value?: number, field: string } & { row: { id: number | string } }) => {
                return (
                    <Box
                        display="flex"
                        flexDirection="column"
                        textAlign="center"
                        alignItems="center"
                        justifyContent="center"
                        width="100%"
                        height="100%"
                    >
                        {(data.row.id === 'delivery' || data.row.id === 'shipment' || data.row.id === 'plannedProduction' || data.row.id === 'demand') &&
                        data.value !== 0 ? (
                            <Button variant="text">
                                {data.value}
                            </Button>
                        ) : (<>
                            {(data.value ?? 0) > 0 ? data.value : 0}
                            <Box fontStyle='italic'>{data.row.id === 'itemStock' && data.field === '0' && '(current)'}</Box></>
                        )}
                    </Box>
                );
            },
            type: 'number',
        };
    });
};

export const getPartnerType = (type: 'customer' | 'supplier') => (type === 'customer' ? 'supplier' : 'customer');

