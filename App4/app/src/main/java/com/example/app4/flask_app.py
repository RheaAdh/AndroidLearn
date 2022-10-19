from flask import Flask,request
app=Flask(__name__)

@app.route("/greetings/<a>")
def greetings(a):
    return "welcome" +a + " !"

@app.route("/add")
def add():
    a=request.args.get("a")
    b=request.args.get("b")
    return str(int(a)+int(b))