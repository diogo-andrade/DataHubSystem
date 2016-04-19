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
package petascope.wcps2.processor;

import petascope.wcps.metadata.DomainElement;
import petascope.wcps2.metadata.Coverage;
import petascope.wcps2.metadata.CoverageRegistry;
import petascope.wcps2.metadata.Interval;
import petascope.wcps2.translator.*;

import java.util.List;

/**
 * This processor translates any petascope axes in a subset to a rasdaman interval
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class PetascopeAxesToRasdamanAxesTranslator implements IProcessor {

    @Override
    public void process(IParseTreeNode translationTree, IParseTreeNode currentNode, CoverageRegistry coverageRegistry) {
        if (currentNode instanceof TrimExpression) {
            TrimExpression trim = (TrimExpression) currentNode;
            processTrimAxes(trim);
        } else if (currentNode instanceof ScaleExpression) {
            ScaleExpression scale = (ScaleExpression) currentNode;
            processScaleAxes(scale);
        }
    }

    @Override
    public boolean canProcess(IParseTreeNode currentNode) {
        if (currentNode instanceof TrimExpression
                || currentNode instanceof ScaleExpression) {
            return true;
        }
        return false;
    }

    /**
     * Processes the axes order for scale operations
     *
     * @param scale
     */
    private void processScaleAxes(ScaleExpression scale) {
        processAxesOrder(scale.getDimensionIntervals(), scale.getCoverage().getCoverageInfo().getDomains(), false);
    }

    /**
     * Processes the axes order for trim operations
     *
     * @param trim
     */
    private void processTrimAxes(TrimExpression trim) {
        Coverage coverage = trim.getCoverageExpression().getCoverage();
        processAxesOrder(trim.getDimensionIntervalList(), coverage.getCoverageInfo().getDomains(), true);
    }

    /**
     * Puts the axes into the order rasdaman expects it to, for example for axes x and y, x might map to the second dimension and y to the first
     * e.g x(0:1),y(0:2) -> [0:2,0:1]
     *
     * @param dimensionIntervals   the trim dimension intervals
     * @param domains              the domains of the axes
     * @param addDefaultIfNotFound if this is set to true, a *:* will be added to each missing dimension in the trim
     */
    private void processAxesOrder(DimensionIntervalList dimensionIntervals, List<DomainElement> domains, boolean addDefaultIfNotFound) {
        for (DomainElement domain : domains) {
            boolean found = false;
            for (TrimDimensionInterval trimInterval : dimensionIntervals.getIntervals()) {
                if (trimInterval.getAxisName().equalsIgnoreCase(domain.getLabel())) {
                    found = true;
                    trimInterval.setAxisPosition(domain.getOrder());
                }
            }
            if (!found && addDefaultIfNotFound) {
                CoverageExpressionVariableName defaultVariable = new CoverageExpressionVariableName(TrimDimensionInterval.WHOLE_DIMENSION_SYMBOL, null);
                TrimDimensionInterval fullInterval = new TrimDimensionInterval(domain.getLabel(), "", defaultVariable, defaultVariable);
                fullInterval.setTrimInterval(new Interval<Long>(Long.MIN_VALUE, Long.MIN_VALUE));
                fullInterval.setAxisPosition(domain.getOrder());
                dimensionIntervals.getIntervals().add(fullInterval);
            }
        }
    }
}
