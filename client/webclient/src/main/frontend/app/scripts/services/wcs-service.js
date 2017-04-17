/*
 *  Created by Diogo: 17/04/2017
 */
'use strict';


var WCSService = {
    describeCoverage: function(productId){
        return http({
            url: ApplicationConfig.baseUrl + "rasdaman/ows?&SERVICE=WCS&VERSION=2.0.1&REQUEST=DescribeCoverage&COVERAGEID="+productId,
            method: "GET"
        });
    }
};