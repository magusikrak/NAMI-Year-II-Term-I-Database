import datetime
from time import time

import validator

if(validator.validate(9)):
    print("the number is greater than 10")
else:
    print("its not greater than 10")