/**
 * http-util.js
 * This script provides functions for transmitting or processing data using HTTP communication.
 * @author Inmook, Jeong
 * @since 2024.03.13
 */
const HttpUtil = (() => {
	
	const REQUEST_METHOD = {
		GET : 'GET',
		POST : 'POST',
		PUT : 'PUT',
		DELETE : 'DELETE'
	}
	
	const RETURN_TYPE = {
		JSON : 'json',
		TEXT : 'text'
	}
	
	// Get function
	const get = async (url, returnType) => {
		const requestObject = {
			method: REQUEST_METHOD.GET
		};
		
		if(returnType === RETURN_TYPE.JSON) {
			return await getJson(url, requestObject);
		} else if(returnType === RETURN_TYPE.TEXT) {
			return await getText(url, requestObject);
		}
	}
	
	const getJson = async (url, requestObject) => {
		const response = await callApi(url, requestObject);
		return await response.json();
	}
	
	const getText = async (url, requestObject) => {
		const response = await callApi(url, requestObject);
		return await response.text()
	}
	
	// Post function
	const post = async (url, sendData, returnType) => {
		if(returnType === RETURN_TYPE.JSON) {
			return await postJson(url, sendData);
		}
	};
	
	const postJson = async (url, sendData) => {
		const requestObject = {
			method: REQUEST_METHOD.POST,
			headers: {
				'Content-Type': 'application/json;charset=utf-8'
			},
			body: JSON.stringify(sendData)
		};
		
		const response = await callApi(url, requestObject);
		return await response.json();
	}
	
	const callApi = async (url, requestObject) => {
		return await fetch(url, requestObject);
	};
	
	return {
		get : get,
		post : post,
		RETURN_TYPE : RETURN_TYPE
	}
});