/*
 * This file is part of rasdaman community.
 *
 * Rasdaman community is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Rasdaman community is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU  General Public License for more details.
 *
 * You should have received a copy of the GNU  General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003 - 2014 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */

package petascope.wms2.service.exception.error;

import org.jetbrains.annotations.NotNull;

/**
 * Class to represent a failure to retrieve the data
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class WMSDataStoreException extends WMSException {
    /**
     * Constructor for the class
     */
    public WMSDataStoreException() {
        super(EXCEPTION_MESSAGE);
    }

    @NotNull
    @Override
    public String getExceptionCode() {
        return EXCEPTION_CODE;
    }

    private final static String EXCEPTION_CODE = "DataStoreFailure";
    private final static String EXCEPTION_MESSAGE = "Could not retrieve the data from the data store";
}
