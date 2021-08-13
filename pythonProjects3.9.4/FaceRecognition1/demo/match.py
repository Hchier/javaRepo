import cv2


def match(matchLibAddress, cascadeClassifierAddress, picAddress):
    # 加载训练数据集文件
    recogizer = cv2.face.LBPHFaceRecognizer_create()
    recogizer.read(matchLibAddress)
    # 准备识别的图片
    img = cv2.imread(picAddress)

    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    face_detector = cv2.CascadeClassifier(
        cascadeClassifierAddress)
    faces = face_detector.detectMultiScale(gray)
    for x, y, w, h in faces:
        cv2.rectangle(img, (x, y), (x + w, y + h), (0, 255, 0), 5)
        # 人脸识别
        id, confidence = recogizer.predict(gray[y:y + h, x:x + w])
        print('标签id:', id, '置信评分：', confidence)
    cv2.imshow('result', cv2.resize(img, dsize=(400, 500)))
    cv2.waitKey(0)
    cv2.destroyAllWindows()


if __name__ == '__main__':
    matchLibAddress = "trainer.yml"
    cascadeClassifierAddress = "D:\opencv\opencv\sources\data\haarcascades\haarcascade_frontalface_default.xml"
    picAddress = "./picsForTest/16.jpg"
    match(matchLibAddress, cascadeClassifierAddress, picAddress)
