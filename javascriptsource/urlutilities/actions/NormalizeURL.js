// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import "mx-global";
import { Big } from "big.js";
import normalizeUrl from 'normalize-url';

// BEGIN EXTRA CODE
// END EXTRA CODE

/**
 * @param {string} uRL
 * @param {string} defaultProtocol - 'https' | 'http'
Default: 'http'
 * @param {boolean} normalizeProtocol - Prepend defaultProtocol to the URL if it's protocol-relative.
Default: true
 * @param {boolean} forceHTTP - Normalize HTTPS to HTTP.
Default: false
 * @param {boolean} forceHttps - Normalize HTTP to HTTPS.
Default: false
 * @param {boolean} stripAuthentication - Strip the authentication part of the URL.
Default: true
 * @param {boolean} stripHash - Strip the hash part of the URL.
Default: false
 * @param {boolean} stripProtocol - Remove the protocol from the URL.
It will only remove https:// and http:// protocols.

Default: false
 * @param {boolean} stripTextFragment - Strip the text fragment part of the URL.
Default: true
 * @param {boolean} stripWWW - Remove www. from the URL.
Default: true
 * @param {boolean} removeQueryParameters - If a boolean is provided, true will remove all the query parameters.
Default: false
 * @param {string} keepQueryParameters - Keeps only query parameters that matches any of the provided strings or regexes.

Note: It overrides the removeQueryParameters option.

Default: undefined
 * @param {boolean} removeTrailingSlash - Remove trailing slash.

Note: Trailing slash is always removed if the URL doesn't have a pathname unless the removeSingleSlash option is set to false

Default: true
 * @param {boolean} removeSingleSlash - Remove a sole / pathname in the output. This option is independent of removeTrailingSlash.

Default: true
 * @param {boolean} removeDirectoryIndex - Removes the default directory index file from path. When true, the regex /^index\.[a-z]+$/ is used.

Default: false
 * @param {boolean} removeExplicitPort - Removes an explicit port number from the URL.

Port 443 is always removed from HTTPS URLs and 80 is always removed from HTTP URLs regardless of this option.

Default: false
 * @param {boolean} sortQueryParameters - Sorts the query parameters alphabetically by key.
Default: true
 * @returns {Promise.<string>}
 */
export async function NormalizeURL(uRL, defaultProtocol, normalizeProtocol, forceHTTP, forceHttps, stripAuthentication, stripHash, stripProtocol, stripTextFragment, stripWWW, removeQueryParameters, keepQueryParameters, removeTrailingSlash, removeSingleSlash, removeDirectoryIndex, removeExplicitPort, sortQueryParameters) {
	// BEGIN USER CODE
	console.info('defaultProtocol:'+defaultProtocol);
	const options = {
		
	defaultProtocol: defaultProtocol != undefined ? defaultProtocol : 'http', 
	normalizeProtocol:normalizeProtocol != undefined ? normalizeProtocol : true,
	forceHTTP:forceHTTP != undefined ? forceHTTP : false,
	forceHttps:forceHttps != undefined ? forceHttps : false,
	stripAuthentication:stripAuthentication != undefined ? stripAuthentication : true,
	stripHash:stripHash != undefined ? stripHash : false,
	stripProtocol:stripProtocol != undefined ? stripProtocol : false,
	stripTextFragment:stripTextFragment != undefined ? stripTextFragment : true,
 	stripWWW:stripWWW != undefined ? stripWWW : true,
  	removeQueryParameters:removeQueryParameters != undefined ? removeQueryParameters : false,
	keepQueryParameters:keepQueryParameters != undefined ? '['+keepQueryParameters+']' : 'undefined',
	removeTrailingSlash:removeTrailingSlash != undefined ? removeTrailingSlash : true,
	removeSingleSlash:removeSingleSlash != undefined ? removeSingleSlash : true,
	removeDirectoryIndex:removeDirectoryIndex != undefined ? removeDirectoryIndex : false,
	removeExplicitPort:removeExplicitPort != undefined ? removeExplicitPort : false,
	sortQueryParameters:sortQueryParameters != undefined ? sortQueryParameters : true,


};

	// Normalize the URL using the normalizeUrl function
	const normalizedUrl = normalizeUrl(uRL,options);

	// Print the original and normalized URLs
	console.info('Original URL:', uRL);
	console.info('Normalized URL:', normalizedUrl);
	return normalizedUrl;
	//throw new Error("JavaScript action was not implemented");
	// END USER CODE
}