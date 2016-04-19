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

import java.util.ArrayList;
import java.util.List;

/**
 * A registry of the managed error cases that we can have during parsing and processing.
 * New error cases should be added as a class extending WCPSSyntaxError under the managed package and
 * should be registered in the registerErrors method of this class.
 *
 * @author <a href="mailto:alex@flanche.net">Alex Dumitru</a>
 * @author <a href="mailto:vlad@flanche.net">Vlad Merticariu</a>
 */
public class ErrorRegistry {

    /**
     * Constructor for the class
     */
    public ErrorRegistry() {
        errorTypes = new ArrayList<WCPSSyntaxError>();
        registerErrors();
    }

    /**
     * Looks up an error in the registry based on the error information we have.
     *
     * @param stack              a stack of the already parsed clauses
     * @param offendingSymbol    the offending symbol where parsing was stopped
     * @param line               the line on which the error occurred
     * @param charPositionInLine the position in line where the error occurred
     * @param msg                the message generated by the parser
     * @return
     */
    public WCPSSyntaxError lookupError(List<String> stack, Object offendingSymbol, int line, int charPositionInLine, String msg) {
        WCPSSyntaxError returnError = null;
        for (WCPSSyntaxError error : errorTypes) {
            error.initialize(stack, offendingSymbol, line, charPositionInLine, msg);
            if (error.canHandle()) {
                returnError = error;
                break;
            }
        }

        //no specific error found return a general one
        if (returnError == null) {
            returnError = new GeneralParsingError();
            returnError.initialize(stack, offendingSymbol, line, charPositionInLine, msg);
        }

        return returnError;
    }

    /**
     * Registers the possible errors that the registry should consider
     * When adding a new error under the managed package, you should probably add it here as well.
     */
    private void registerErrors() {
        errorTypes.add(new MissingCoveragePrefixError());
    }

    private final ArrayList<WCPSSyntaxError> errorTypes;

}
