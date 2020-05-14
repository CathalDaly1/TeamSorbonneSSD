import os
# import connexion
from flask_sqlalchemy import SQLAlchemy
# from flask_marshmallow import Marshmallow
from flask import Flask
from flask_restful import Api, Resource, reqparse

basedir = os.path.abspath(os.path.dirname(__file__))

# Create the connexion application instance
#connex_app = connexion.App(__name__, specification_dir=basedir)

# Get the underlying Flask app instance
#app = connex_app.app

app = Flask(__name__)
api = Api(app)

# Build the Sqlite ULR for SqlAlchemy
uri = "postgres://ynxdugqyconiwd:832d325ad51261c595dc5710f4d1a9e9d1ca0be37eb13a8b2d48ede91a999224@ec2-54-246-116-119.eu-west-1.compute.amazonaws.com:5432/dfbdhscjrr76l8"

# Configure the SqlAlchemy part of the app instance
app.config["SQLALCHEMY_ECHO"] = True
app.config["SQLALCHEMY_DATABASE_URI"] = uri
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

# Create the SqlAlchemy db instance
db = SQLAlchemy(app)

# Initialize Marshmallow
# ma = Marshmallow(app)