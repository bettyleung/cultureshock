import os

from flask import Flask, request, redirect, url_for, render_template, jsonify

import dao
from utils import make_json_app

app = make_json_app(__name__)
app.config.from_object(__name__)


@app.route("/categories")
def get_categories():
    return jsonify(dao.get_categories())


def main():
    import sys
    if "-d" in sys.argv or "--debug" in sys.argv:
        print "Running in debug mode"
        app.debug = True
    print "Server is available externally"
    app.run("0.0.0.0")


if __name__ == "__main__":
    main()
