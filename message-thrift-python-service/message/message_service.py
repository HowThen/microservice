# coding: utf-8
from message.api import MessageService
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server import TServer

import smtplib
from email.mime.text import MIMEText
from email.header import Header

sender = '584973593@qq.com'
authCode = ''


class MessageSerivceHandler:
    def sendMobileMessage(self, mobile, message):
        print("sendMobileMessage, mobile" + mobile + ", messgae:" + message)
        return True

    def sendEmailMessage(self, email, messgae):
        print("sendEmailMessage, email:" + email + ", message:" + messgae)
        messgaeObj = MIMEText(messgae, "plain", "utf-8")
        messgaeObj['From'] = sender
        messgaeObj['To'] = email
        messgaeObj['Subject'] = Header('微服务测试邮件', 'utf-8')
        try:
            smtpObj = smtplib.SMTP('smpt.qq.com')
            smtpObj.login(sender, authCode)
            smtpObj.sendmail(sender, [email], messgaeObj.as_string())
            print("send mail success")
            return True
        except smtplib.SMTPException as ex:
            print("send mail failed!")
            print(ex)
            return False


if __name__ == '__main__':
    handler = MessageSerivceHandler()
    processor = MessageService.Processor(handler)
    transport = TSocket.TServerSocket("localhost", "9090")
    tfactory = TTransport.TFramedTransportFactory()
    pfactory = TBinaryProtocol.TBinaryProtocolFactory()

    server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)
    print("python thrift server start")
    server.serve()
    print("python thrift server exit")
