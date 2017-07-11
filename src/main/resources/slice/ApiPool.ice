#ifndef APIPOOL_H
#define APIPOOL_H

module APIPOOL
{
    dictionary<string,string> PARAMS;
    interface Service
    {
        ["amd"] int microseerRequest(PARAMS keys,out string outString);
        int microseerBroadcast(PARAMS keys,out string outString);
    };
};
#endif
