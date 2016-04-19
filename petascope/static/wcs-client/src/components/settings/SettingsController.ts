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

///<reference path="../../../assets/typings/tsd.d.ts"/>

///<reference path="SettingsService.ts"/>

module rasdaman {
    export class SettingsController {
        public static $inject = [
            "$scope",
            "rasdaman.SettingsService"
        ];

        public constructor(private $scope:SettingsControllerScope, private settingsService:rasdaman.SettingsService) {
            $scope.WCSEndpoint = settingsService.WCSEndpoint;

            $scope.updateSettings = function () {
                console.log($scope.WCSEndpoint);
            };
        }
    }

    export interface SettingsControllerScope extends angular.IScope {
        WCSEndpoint:string;
        updateSettings():void;
    }
}