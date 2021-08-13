from flask import Flask, render_template, request, Response, jsonify
from flask_cors import CORS
import json
import cv2
import numpy
import base64

app = Flask(__name__)
CORS(app, supports_credentials=True)

#
# @app.route('/')
# def hello_world():
#     return Response('hello_world')


@app.route('/')
def video_sample():
    return render_template('camera.html')


@app.route('/receiveImage/', methods=["POST"])
def receive_image():
    if request.method == "POST":
        data = request.data.decode('utf-8')
        print("data:", data)
        json_data = json.loads(data)
        str_image = json_data.get("imgData")
        img = base64.b64decode(str_image)
        img_np = numpy.fromstring(img, dtype='uint8')
        new_img_np = cv2.imdecode(img_np, 1)
        cv2.imwrite('./images/rev_image.jpg', new_img_np)
        print('data:{}'.format('success'))

    return Response('upload')


if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)
