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
package petascope.wcps2.error.managed.processing;

/**
 * Error exception for coverage axis lookup failure
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class CoverageAxisNotFoundExeption extends WCPSProcessingError {
    /**
     * Constructor for the class
     *
     * @param axisName the axis that was provided
     */
    public CoverageAxisNotFoundExeption(String axisName) {
        this.axisName = axisName;
    }

    /**
     * Getter for the axis name
     *
     * @return
     */
    public String getAxisName() {
        return axisName;
    }

    private final String axisName;
    private static final String TEMPLATE = "Coverage Axis not found: $axisName";
}
