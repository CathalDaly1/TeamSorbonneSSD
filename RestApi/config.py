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
uri = "postgres://cxsmrevlzgagpc:0076d37587d72c8c7669a203d715c81cb8cfb2b069a8615b6021a6ad2bb66a8c@ec2-54-228-243-238.eu-west-1.compute.amazonaws.com:5432/d3cc849aaemsbe"

# Configure the SqlAlchemy part of the app instance
app.config["SQLALCHEMY_ECHO"] = True
app.config["SQLALCHEMY_DATABASE_URI"] = uri
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

# Create the SqlAlchemy db instance
db = SQLAlchemy(app)

# Initialize Marshmallow
# ma = Marshmallow(app)