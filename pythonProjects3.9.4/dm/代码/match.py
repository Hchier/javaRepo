import cv2


def match(matchLibAddress, cascadeClassifierAddress, picAddress):
    recogizer = cv2.face.LBPHFaceRecognizer_create()
    recogizer.read(matchLibAddress)
    # 准备识别的图片
    img = cv2.imread(picAddress)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    face_detector = cv2.CascadeClassifier(
        cascadeClassifierAddress)
    faces = face_detector.detectMultiScale(gray)
    for x, y, w, h in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (0, 255, 0), 2)
        # 人脸识别
        id, confidence = recogizer.predict(gray[y:y + h, x:x + w])
        print('标签id:', id, '置信评分：', confidence)
    cv2.imshow('result', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


if __name__ == '__main__':
    match(r'./trainer/trainer.yml',
          'D:\opencv\opencv\sources\data\haarcascades\haarcascade_frontalface_default.xml',
          '11.pgm')


