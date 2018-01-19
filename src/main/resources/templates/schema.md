The rest_v2/users service provides methods that allow you to list, view, create, modify, and delete user accounts, including setting role membership. The service provides improved search functionality, such as organizationbased searches in commercial editions licensed to use organizations. Every method has two URL forms, onewith an organization ID and one without.

Only administrative users may access the users service. System admins (superuser) can define and modify usersanywhere in the server, and organization admins (jasperadmin) can define and modify users within their ownorganization or any sub-organizations.

"Query execution API provide ability to run Ad Hoc Query.\r\nThere\
    \ are two possible way to run a query: synchronous and asynchronous.\r\n\r\n#\
    \ Asynchronous\r\n\r\nThe rest_v2/queryExecutions service provides asynchronous\
    \ query execution,\r\nso that the client does not need to wait for query dataset\
    \ result.\r\nInstead, the client obtains a execution ID and periodically checks\
    \ the\r\nstatus of the query executions to know when it is ready (also called\r\
    \npolling). When the query is finished, the client can get result dataset,\r\n\
    by GET operation with path\r\n[rest_v2/queryExecutions/{executionId}/data](/#getData).\
    \ Pay, attention\r\nthat this operation is always synchronous, so ones your run\
    \ it, then you\r\nwill wait until result can be ready.\r\n\r\n# Synchronous\r\n\
    \r\nIf client don't mind to wait response or he really sure, that query is \r\n\
    executed pretty quickly and don't impact perfomance, then it has ability \r\n\
    to run query execution synchronously. In this case only one operation \r\n(create\
    \ query execution) with specific Mime-Types for getting \r\ndata(application/flatData\
    \ for example) is required to run a query and get \r\nresult without doing additional\
    \ check status and getting data operation.\r\n\r\n\r\n# Formatting\r\n\r\n# I.\
    \ Date and Timestamp formatting\r\n\r\nQuery Execution Rest API return the date\
    \ and timestamp in ISO-8601 format:\r\n- Time -  HH:mm:ss.SSSZ\r\n- Date - yyyy-MM-dd\r\
    \n- Timestamp - yyyy-MM-dd'T'HH:mm:ss.SSSZ\r\n# II. Numeric data formatting\r\n\
    Numeric data is formatted with mask - ####.##########. The number of digit\r\n\
    after \\\".\\\" in floating point number is configurable - by default it equals\r\
    \n10 and can be changed in iso_data_formats.properties.\r\n\r\n# III. Categorization\r\
    \n\r\n<table>\r\n  <thead>\r\n  <tr>\r\n      <th>\r\n          <div>\r\n    \
    \          <div>Name</div>\r\n          </div>\r\n      </th>\r\n      <th>\r\n\
    \          <div>\r\n              <div>Examples</div>\r\n          </div>\r\n\
    \      </th>\r\n  </tr>\r\n  </thead>\r\n  <tbody>\r\n  <tr>\r\n      <td>day</td>\r\
    \n      <td>2005-11-03</td>\r\n  </tr>\r\n  <tr>\r\n      <td>hour</td>\r\n  \
    \    <td>19:00:00.000+0200</td>\r\n  </tr>\r\n  <tr>\r\n      <td>hour_by_day</td>\r\
    \n      <td>2005-11-03T19:00:00.000+0200</td>\r\n  </tr>\r\n  <tr>\r\n      <td>millisecond</td>\r\
    \n      <td>19:19:03.112+0200</td>\r\n  </tr>\r\n  <tr>\r\n      <td>millisecond_by_day</td>\r\
    \n      <td>2005-11-03T19:19:03.112+0200</td>\r\n  </tr>\r\n  <tr>\r\n      <td>\r\
    \n          <p>minute</p>\r\n      </td>\r\n      <td>19:19:00.000+0200</td>\r\
    \n  </tr>\r\n  <tr>\r\n      <td>minute_by_day</td>\r\n      <td>2005-11-03T19:19:00.000+0200</td>\r\
    \n  </tr>\r\n  <tr>\r\n      <td>month</td>\r\n      <td>2005-11</td>\r\n  </tr>\r\
    \n  <tr>\r\n      <td>quarter</td>\r\n      <td>2005-Q1</td>\r\n  </tr>\r\n  <tr>\r\
    \n      <td>second</td>\r\n      <td>19:19:03.000+0200</td>\r\n  </tr>\r\n  <tr>\r\
    \n      <td>second_by_day</td>\r\n      <td>2005-11-03T19:19:03.000+0200</td>\r\
    \n  </tr>\r\n  <tr>\r\n      <td>year</td>\r\n      <td>2005</td>\r\n  </tr>\r\
    \n  </tbody>\r\n</table>"


```
openApi.path(/getUser)
```