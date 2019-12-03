from flask import Flask, jsonify
import psycopg2
import json

conn = psycopg2.connect(host="ec2-54-246-116-119.eu-west-1.compute.amazonaws.com",database="dfbdhscjrr76l8", user="ynxdugqyconiwd", password="832d325ad51261c595dc5710f4d1a9e9d1ca0be37eb13a8b2d48ede91a999224")

cur = conn.cursor()

def executeQuery(query):
        cur.execute(query)
        row_headers=[x[0] for x in cur.description] #this will extract row headers
        rv = cur.fetchall()
        json_data_inner = []
        for result in rv:
            json_data_inner.append(dict(zip(row_headers,result)))
        json_dict = {"results": json_data_inner}
        return json.dumps(json_dict)

def executeQueryParameterised(query, param):
    cur.execute(query, (param,))
    row_headers=[x[0] for x in cur.description] #this will extract row headers
    rv = cur.fetchall()
    json_data_inner = []
    for result in rv:
        json_data_inner.append(dict(zip(row_headers,result)))
    json_dict = {"results": json_data_inner}
    return json.dumps(json_dict)

def insert(query):
    print(query)
    cur.execute(query)
    conn.commit()
    return 200

def delete(query):
    cur.execute(query)
    conn.commit()
    return 200