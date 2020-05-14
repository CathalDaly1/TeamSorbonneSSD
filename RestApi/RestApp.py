from flask import Flask, jsonify
from flask_restful import Api, Resource, reqparse
import psycopg2
from paths import *

app = Flask(__name__)
api = Api(app)

api.add_resource(UserPath, "/user/")

api.add_resource(UserNamePath,"/user/<string:name>")

api.add_resource(PartTypePath, "/part/<string:partType>")

api.add_resource(PartNamePath, "/partId/")

api.add_resource(PartPath, "/parts/")

api.add_resource(PCBuildsUidTypePath, "/pc_build/")

api.add_resource(AdvertPath, "/advert/")

api.add_resource(PartIdPath, "/partDetails/")

api.add_resource(AdvertTypePath, "/advertsByType/")

api.add_resource(TransactionPath, "/transaction/")

api.add_resource(UserPathById, "/userById/")

api.add_resource(Review, "/review/")


app.run(debug=True, host= '192.168.1.12')

