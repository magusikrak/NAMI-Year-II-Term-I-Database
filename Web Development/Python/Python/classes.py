class Person:
    def __init__(self,name,age):
        self.name=name
        self.age=age

    def getHello(self):
        return (f"my name is {self.name}")

sugam=Person("sugam",19)
print(sugam.getHello())