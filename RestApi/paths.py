from flask_restful import Api, Resource, reqparse
from dbFunctions import *
import json

class UserPath(Resource):
    def get(self):
        jsonData = executeQuery('''Select * from users''')
        return jsonData, 200

class UserNamePath(Resource):

    def get(self,name):
        jsonData = executeQuery('''Select * from users where username = \'''' +  name + '\'')
        return jsonData, 200

    def post(self, name):
        parser = reqparse.RequestParser()
        parser.add_argument("username")
        parser.add_argument("password")
        parser.add_argument("email")
        parser.add_argument("premium")

        args = parser.parse_args()

        insert('''INSERT INTO users (username,email,password,premium) VALUES(\''''+ str(args["username"]) + '''\',\'''' + str(args["email"]) + '''\',\'''' + str(args["password"]) + '''\',\'''' + str(args["premium"]) + '''\')''')

        return 200

class PartTypePath(Resource):

    def get(self, partType):
        sql = '''SELECT name from parts where type = %s '''
        json_data = executeQueryParameterised(sql,partType)
        return json_data, 200

class PartPath(Resource):

    def get(self):
        sql = '''SELECT name from parts'''
        json_data = executeQuery(sql)
        return json_data, 200

class PartIdPath(Resource):
    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("pid")

        args = parser.parse_args()
        sql = '''SELECT *  from parts where pid = ''' + str(args["pid"])
        json_data = executeQuery(sql)
        return json_data, 200


class PartNamePath(Resource):

    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("partName")

        args = parser.parse_args()
        # sql = '''SELECT pid from parts where name = %s '''
        # json_data = executeQueryParameterised(sql, str(args["partName"]))
        json_data = executeQuery('''SELECT pid from parts where name = \'''' + str(args["partName"]) + '''\'''')
        return json_data, 200



class PCBuildsUidTypePath(Resource):

    def delete(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")
        parser.add_argument("type")

        args = parser.parse_args()

        delete('''  DELETE FROM pc_builds where uid = ''' + str(args["uid"]) + ''' AND type = \'''' + str(args["type"]) + '''\'''')

        return 200

    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")
        parser.add_argument("type")
        parser.add_argument("pid")


        args = parser.parse_args()

        insert('''INSERT INTO pc_builds(uid,pid,type) VALUES('''+ str(args["uid"]) +  ''',''' + str(args["pid"]) + ''',\'''' + str(args["type"]) + '''\')''')

        return 200

    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")

        args = parser.parse_args()
        json_data = executeQuery('''SELECT pid from pc_builds where uid = ''' + str(args["uid"]))
        return json_data, 200


class AdvertPath(Resource):

    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")
        parser.add_argument("pid")
        parser.add_argument("price")


        args = parser.parse_args()

        insert('''INSERT INTO adverts(uid,pid,price) VALUES('''+ str(args["uid"]) +  ''',''' + str(args["pid"]) + ''',''' + args["price"] + ''')''')

        return 200

    def delete(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")
        parser.add_argument("pid")

        args = parser.parse_args()

        delete('''  DELETE FROM adverts where uid = ''' + str(args["uid"]) + ''' AND pid = ''' + str(args["pid"]))

        return 200

class AdvertTypePath(Resource):
    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("partType")

        args = parser.parse_args()

        json_data = executeQuery('''select * from adverts inner join parts on adverts.pid = parts.pid where parts.type = \'''' + str(args["partType"])  + '''\'''')
        return json_data,200

class TransactionPath(Resource):
    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid1")
        parser.add_argument("uid2")
        parser.add_argument("pid")
        parser.add_argument("price")


        args = parser.parse_args()

        insert('''INSERT INTO transactions(uid1,uid2,pid,price) VALUES('''+ str(args["uid1"]) +  ''',''' + str(args["uid2"]) +  ''',''' + str(args["pid"]) + ''',''' + args["price"] + ''')''')

        return 200
        
    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")

        args = parser.parse_args()

        json_data = executeQuery('''SELECT * FROM transactions where uid1 = '''+ str(args["uid"]) +  ''' OR uid2 = ''' + str(args["uid"]))

        return json_data, 200

class UserPathById(Resource):
    def get(self):
        parser = reqparse.RequestParser()
        parser.add_argument("uid")

        args = parser.parse_args()

        json_data = executeQuery('''SELECT * FROM users where uid = ''' + str(args["uid"]))

        return json_data,200


class Review(Resource):
    def post(self):
        parser = reqparse.RequestParser()
        parser.add_argument("tid")
        parser.add_argument("rating")
        parser.add_argument("buyerComment")

        args = parser.parse_args()

        insert('''INSERT INTO reviews(tid,rating,buyerComment) VALUES('''+ str(args["tid"]) +  ''',''' + str(args["rating"]) +  ''',\'''' + str(args["buyerComment"]) + '''\')''')

        return 200