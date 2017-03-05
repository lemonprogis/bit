/**
 * my api client
 */
var api = {};

// make objects per entity
api.issue = {};
api.people = {};
api.project = {};

api.rootEndpoint = "/api";

/**
 * Issue methods
 */
api.issue.get = function(callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue",
		type: "GET",
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.issue.create = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue",
		type: "POST",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.issue.update = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue",
		type: "PUT",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.issue.delete = function(id, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue/" + id,
		type: "DELETE",
		headers: headers,
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

/**
 * People methods
 */
api.people.get = function(callback) {
	$.ajax({
		url: api.rootEndpoint + "/people",
		type: "GET",
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.people.create = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue",
		type: "POST",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.people.update = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue",
		type: "PUT",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.people.delete = function(id, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/issue/" + id,
		type: "DELETE",
		headers: headers,
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

/**
 * Project methods
 */
api.getProjects = function(callback) {
	$.ajax({
		url: api.rootEndpoint + "/project",
		type: "GET",
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.project.create = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/project",
		type: "POST",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.project.update = function(obj, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/project",
		type: "PUT",
		headers: headers,
		data: JSON.stringify(obj),
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};

api.project.delete = function(id, headers, callback) {
	$.ajax({
		url: api.rootEndpoint + "/project/" + id,
		type: "DELETE",
		headers: headers,
		success: callback,
		error: function(error) {
			console.error(error);
		}
	});
};
