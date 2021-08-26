
# Repository 
Local Repository 
- Kolon Benit, BigData Analytics Team, Austin Rho, (Shin Seok)
- last update: 2020.03.01 

## 0. Architecture
- Impala



## A. Code List

**1. Impala waiting to be closed**

I understand that you would like to know information about ‘waiting to be closed’ state queries.

I hope you are running queries through Hue. 

1. When Impala queries are submitted, they are first registered, which means that they are known by some coordinator and have some state (for example, CREATED, INITIALIZED, RUNNING, FINISHED, EXCEPTION) and metadata.
2. Currently Impala does not have a state that explicitly indicates all Impala daemons have finished executing the query and all results have been fetched. Let's call it EOS temporarily.
3. When a query is at EOS (state is still FINISHED) or EXCEPTION, the query is not doing any more processing, but the query remains registered(waiting to be closed). It needs to remain registered because clients may need to access the state.
4. Queries are only unregistered in two cases: - The query is explicitly closed via a Close() API call. - The session associated with the query is closed, e.g. explicitly closed OR the session timeout is set and the session times out.
5. “Waiting to be closed" state is terminal in Impala. The next action expected is for the client to close the query, the session to close, or the connection to terminate (which terminate the session and the query). This is the expected behavior of impala

For example:
Users may run a query, page through some subset of results, submit another query, continue to page through the first query’s results, etc. Thus a number of queries may remain registered at a given time. A Hue user may have several Hue tabs open, each with a number of queries. Hue will not close the queries (i.e. sending the “Close” API call) until the tab is explicitly closed

6. The queries showing as "waiting to be closed" state for a long time although they have already been completed is known, and this is just a behaviour because of how Hue/Impala interaction has to work today as this would allow the user to check back the results if required. At this point setting the query_timeout_s and session_timeout_s to a reasonable value would allow the queries to timeout themselves. Once the queries timeout, even if the session remains open or the query appears to be executing, the resources are freed up.
7. Setting up timeouts are the solution for this issue. Refer arcticle[1] for more information on this.

[1] https://my.cloudera.com/knowledge/Finished-Queries-show-as-Executing-in-the-Cloudera-Manager?id=71576




**2. ./py-script/**

    - make-cran-meta.py : Create R meta file 
    - make-current-repo.py : Compare libraries
	- make-download-copy-script.py : Make download script



## B. R U Ready?
    - windows key + R
    - type "CMD"  and run CMD Window
    - type "git clone https://github.com/joyer7/repository.git" on command window
    - Enjoy It !!!
    

## C. Question & Answer
Please feel free to contact Austin Rho 
    - ssrho@kolon.com, injoyer@yonsei.ac.kr


