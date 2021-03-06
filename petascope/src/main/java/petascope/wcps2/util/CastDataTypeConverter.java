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
 * Copyright 2003 - 2016 Peter Baumann / rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */
package petascope.wcps2.util;

import petascope.util.WcpsConstants;

/**
 * Utility class to convert a petascope data type to a rasdaman data type
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class CastDataTypeConverter {

    /**
     * This is only a static class so make sure no one instantiates it
     */
    private CastDataTypeConverter() {
        throw new AssertionError("This class should not be instantiated");
    }

    /**
     * Converts a petascope data type to a rasdaman data type
     *
     * @param dataTypeToBeConverted the data type to be converted
     * @return the rasdaman data type
     */
    public static String convert(String dataTypeToBeConverted) {
        String result = dataTypeToBeConverted.toLowerCase();
        if (result.equals(WcpsConstants.MSG_BOOLEAN)) {
            result = WcpsConstants.MSG_BOOL;
        } else if (result.equals(WcpsConstants.MSG_CHAR)) {
            result = WcpsConstants.MSG_OCTET;
        } else if (result.equals(WcpsConstants.MSG_UNSIGNED_CHAR)) {
            result = WcpsConstants.MSG_CHAR;
        } else if (result.equals(WcpsConstants.MSG_INT)) {
            result = WcpsConstants.MSG_LONG;
        } else if (result.equals(WcpsConstants.MSG_UNSIGNED_INT)) {
            result = WcpsConstants.MSG_UNSIGNED_LONG;
        } else if (result.equals(WcpsConstants.MSG_UNSIGNED_LONG)) {
            result = WcpsConstants.MSG_LONG;
        } else if (result.equals(WcpsConstants.MSG_COMPLEX + "2")) {
            result = WcpsConstants.MSG_COMPLEX + "d";
        }
        //short, unsigned short and complex have identity mapping
        return result;
    }
}
