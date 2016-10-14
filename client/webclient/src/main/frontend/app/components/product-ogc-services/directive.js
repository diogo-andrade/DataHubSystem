/* 
 * Data HUb Service (DHuS) - For Space data distribution.
 * Copyright (C) 2013,2014,2015,2016 European Space Agency (ESA)
 * Copyright (C) 2013,2014,2015,2016 GAEL Systems
 * Copyright (C) 2013,2014,2015,2016 Serco Spa
 * 
 * This file is part of DHuS software sources.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
angular.module('DHuS-webclient')

.directive('productOgcServices', function($location,$document, ProductDetailsModelService) {
  return {
    restrict: 'AE',
    replace: true,
    templateUrl: 'components/product-ogc-services/view.html',
    scope: {
      text: "="
    },
    compile: function(tElem, tAttrs){
        return {
          pre: function(scope, iElem, iAttrs){
          },
          post: function(scope, iElem, iAttrs){
            scope.ola = "This is a test this a test this a test this a test this a test this a test this a test this a test this a test this a test" +
                "this a test this a test this a test this a test this a test this a test this a test this a test";

            scope.model=null;
            scope.products = ProductDetailsModelService.products;
            scope.uuid = null;
            scope.product = null;
            scope.link = null;
            iAttrs.$observe('productUuid',
                function(newValue){
                  scope.uuid = newValue;
                  scope.model = _.findWhere(scope.products.list, {uuid: scope.uuid});
                  var product = _.findWhere(scope.model.indexes,{name:"product"});
                    if(product) {
                    var title = scope.model.identifier;
                    var polarisation = _.findWhere(product.children, {name:"Polarisation"});
                    polarisation = (polarisation) ? polarisation.value.split(" ") : 'empty'
                    var productLevel = _.findWhere(product.children, {name:"Product level"});
                    var productType = _.findWhere(product.children, {name:"Product type"});
                    productLevel = (productLevel) ? productLevel.value.match(/\d/g).join("") : '';
                    productType = (productType) ? productType.value : '';
                    scope.polarisation  = polarisation;
                    if(productLevel == "1" && productType == "GRD") {
                      scope.OGCServicesVisible = true;
                      scope.level = productLevel;
                      var results = [];
                      for (var i = 0; i < polarisation.length; i++) {
                        var url = ApplicationConfig.baseUrl + 'rasdaman/static/wcs-client/index.html#/';
                        var filename = title + '_' + polarisation[i];
                        var coverage = {id: filename, wcs: url + 'describe-coverage/' + filename, wms: url + 'get-map/' + filename};
                        results.push(coverage);
                        scope.coverages = results;
                      }
                    } else {
                      scope.OGCServicesVisible = false;
                    }
                  }
                });
          }
        }
      }
  };
});
