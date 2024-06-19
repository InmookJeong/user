/**
 * http-util.js
 * This script provides functions for transmitting or processing data using HTTP communication.
 * @author Inmook, Jeong
 * @since 2024.03.13
 */
var HttpUtil = HttpUtil || (function() {
	
	/**
	 * HttpUtil namespace
	 */
	var H = {};
	
	REQUEST_METHOD = H.REQUEST_METHOD = {
		GET : 'GET',
		POST : 'POST',
		PUT : 'PUT',
		DELETE : 'DELETE'
	};
	
	RETURN_TYPE = H.RETURN_TYPE = {
		JSON : 'json',
		TEXT : 'text'
	};
	
	// Get function
	H.get = (async function(url, returnType) {
		const requestObject = {
			method: REQUEST_METHOD.GET
		};
		
		if(returnType === RETURN_TYPE.JSON) {
			return await getJson(url, requestObject);
		} else if(returnType === RETURN_TYPE.TEXT) {
			return await getText(url, requestObject);
		}
	});
	
	getJson = async (url, requestObject) => {
		const response = await callApi(url, requestObject);
		return response.json();
	};
	
	getText = async (url, requestObject) => {
		const response = await callApi(url, requestObject);
		return response.text()
	};
	
	// Post function
	H.post = (async function(url, sendData, returnType) {
		if(returnType === RETURN_TYPE.JSON) {
			return await postJson(url, sendData);
		} else if(returnType === RETURN_TYPE.TEXT) {
			return await postText(url, sendData);
		}
	});
	
	postJson = async (url, sendData) => {
		const requestObject = {
			method: REQUEST_METHOD.POST,
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify(sendData),
		};
		
		const response = await callApi(url, requestObject);
		return response.json();
	};
	
	postText = async (url, sendData) => {
		const requestObject = {
			method: REQUEST_METHOD.POST,
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: sendData
			/*body: JSON.stringify(sendData)*/
		};
		
		return await callApi(url, requestObject).text();
	};
	
	callApi = async (url, requestObject) => {
		return await fetch(url, requestObject);
	};
	
	return H;
}());