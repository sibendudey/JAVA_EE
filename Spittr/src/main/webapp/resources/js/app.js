/**
 * 
 */
'use strict';

var app = angular.module('myApp' , []);
var REST_SERVICE_API = 'http://localhost:8080/Spittr/register';

var factory = {
		fetchSpitters: fetchSpitters,
		createSpitter: createSpitter,
		updateSpitter: updateSpitter,
		createSpittle: createSpittle,
		updateSpittle: updateSpittle,
		fetchSpittles: fetchSpittles
};

