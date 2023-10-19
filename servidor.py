import socket

HOST = '127.0.0.1'
PORT = 5000

tcp = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
tcp.bind((HOST,PORT))
tcp.listen(1)
print("Server is listening")
conn,addr=tcp.accept()
print('Connected to:', addr)
while True:
    data= conn.recv(1024)
    print('Cliente: ',data.decode(encoding='UTF-8'))
    dataoutput = input('Servidor: ')
    if not data:
        break
    conn.sendall(bytes(dataoutput+"\r\n",'UTF-8'))
conn.close()   