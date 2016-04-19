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
package petascope.wcps2.error.managed.syntax;

/**
 * Syntax error class for missing coverage prefix
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class MissingCoveragePrefixError extends WCPSSyntaxError {

    @Override
    public boolean canHandle() {
        boolean containsCVName = this.message.contains("expecting COVERAGE_VARIABLE_NAME");
        boolean offendingSymbolStartsWithPrefix = this.offendingSymbol.toString().contains("$");
        if (containsCVName && !offendingSymbolStartsWithPrefix) {
            return true;
        }
        return false;
    }

    @Override
    public String getErrorMessage() {
        String error = ERROR_TEMPLATE.replace("$line", Integer.toString(line))
                .replace("$charPositionInLine", Integer.toString(charPositionInLine))
                .replace("$offendingSymbol", offendingSymbol.toString())
                .replace("$parserMessage", message);
        return error;
    }

    public static final String ERROR_TEMPLATE = "A parsing error occurred at position=$line:$charPositionInLine. \n" +
            "Offending symbol is=$offendingSymbol. Parser message=$parserMessage.\nSuggestions: Please check that the coverage " +
            "iterator starts with the correct prefix '$'.";
}
