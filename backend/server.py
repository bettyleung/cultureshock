import os

from flask import Flask, request, redirect, url_for, render_template, jsonify

import dao
from utils import make_json_app

app = make_json_app(__name__)
app.config.from_object(__name__)


@app.route("/<country>/categories")
def get_categories(country):
    return jsonify(dao.get_categories())


@app.route("/<country>/tips")
def get_tips(country):
    category = request.args.get("category", None)
    subcategory = request.args.get("subcategory", None)
    tags = request.args.get("tags", None)

    return jsonify(tips=dao.get_tips(category, subcategory,
        tags.split(',') if tags is not None else None))


def main():
    import sys
    if "-d" in sys.argv or "--debug" in sys.argv:
        print "Running in debug mode"
        app.debug = True
    print "Server is available externally"
    app.run("0.0.0.0", port=3448)


if __name__ == "__main__":
    main()
