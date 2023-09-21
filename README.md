# URL Utilities:

### URL Parse:
Parsing and working with URLs which allows you to take a URL string and break it down into its constituent parts (such as the protocol, hostname, pathname, query parameters, etc.), making it easy to access and manipulate specific components of the URL.

### Normalize URL:
Standardizes the URL according to various rules, ensuring that the resulting URL is well-formed and consistent.

## Dependencies:
•	Mendix modeler 9.12.4.

## Features

### URL Parse:

#### •	protocol: 
The protocol scheme of the URL (e.g. http:).
#### •	slashes: 
A boolean which indicates whether the protocol is followed by two forward slashes (//).
#### •	auth: 
Authentication information portion (e.g. username:password).
#### •	username: 
Username of basic authentication.
#### •	password: 
Password of basic authentication.
#### •	host: 
Host name with port number. The hostname might be invalid.
#### •	hostname: 
Host name without port number. This might be an invalid hostname.
#### •	port: 
Optional port number.
#### •	pathname: 
URL path.
#### •	query: 
Parsed object containing query string, unless parsing is set to false.
#### •	hash: 
The "fragment" portion of the URL including the pound-sign (#).
#### •	href: 
The full URL.
#### •	origin: 
The origin of the URL.

### Normalize URL:

#### •	defaultProtocol: 
'https' | 'http'
#### •	normalizeProtocol: 
Prepend defaultProtocol to the URL if it's protocol-relative.
#### •	forceHTTP: 
Normalize HTTPS to HTTP.
#### •	forceHttps: 
Normalize HTTP to HTTPS.
#### •	stripAuthentication: 
Strip the authentication part of the URL.
#### •	stripHash: 
Strip the hash part of the URL.
#### •	stripProtocol: 
Remove the protocol from the URL.
#### •	stripTextFragment: 
Strip the text fragment part of the URL.
#### •	stripWWW: 
Remove www. from the URL.
#### •	removeQueryParameters: 
If a boolean is provided, true will remove all the query parameters.
#### •	keepQueryParameters: 
Keeps only query parameters that matches any of the provided strings or regexes.
#### •	removeTrailingSlash: 
Remove trailing slash.
#### •	removeSingleSlash: 
Remove a sole / pathname in the output. This option is independent of removeTrailingSlash.
#### •	removeDirectoryIndex: 
Removes the default directory index file from path. When true, the regex /^index\.[a-z]+$/ is used.
#### •	removeExplicitPort: 
Removes an explicit port number from the URL.
Port 443 is always removed from HTTPS URLs and 80 is always removed from HTTP URLs regardless of this option.
#### •	sortQueryParameters: 
Sorts the query parameters alphabetically by key.

## Issues, suggestions and feature requests

https://github.com/bharathidas/URLUtilities/issues


