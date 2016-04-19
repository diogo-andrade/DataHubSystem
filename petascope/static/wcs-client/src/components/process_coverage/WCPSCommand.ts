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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with rasdaman community.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015 Peter Baumann /
 rasdaman GmbH.
 *
 * For more information please see <http://www.rasdaman.org>
 * or contact Peter Baumann via <baumann@rasdaman.com>.
 */

///<reference path="../../common/_common.ts"/>
///<reference path="WidgetConfiguration.ts"/>

module rasdaman {
    export class WCPSCommand {
        public Query:string;
        public WidgetConfiguration:WidgetConfiguration;

        public constructor(command:string) {
            rasdaman.common.ArgumentValidator.isNotNull(command, "command");

            if (command.indexOf(">>") == -1) {
                this.WidgetConfiguration = null;
                this.Query = command;
            } else {
                var commandParts = command.split(">>");

                var widget:WidgetConfiguration = {
                    Type: commandParts[0],
                    Parameters: null
                };

                if (commandParts[0].indexOf("(") != -1) {
                    var widgetParams:string[] = commandParts[0].substring(commandParts[0].indexOf("(") + 1, commandParts[0].indexOf(")")).split(",");
                    var params = {};
                    widgetParams.forEach((param:string)=> {
                        var parts = param.split("=");
                        params[parts[0]] = parts[1];
                    });

                    widget.Type = commandParts[0].substring(0, commandParts[0].indexOf("("));
                    widget.Parameters = params;
                }

                this.WidgetConfiguration = widget;
                this.Query = commandParts[1];
            }
        }
    }
}