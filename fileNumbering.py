'''
  Instructions:
   #1.  this cell, specify the right path
   #2.  next cell, pick action (1 or 2) 
'''
import os
import codecs
# encoding: chinese
import sys

def isInt(s):
    try:
        int(s)
        return True
    except:
        return False
    
#os.getcwd()
path = 'C:\Users\Simon\Music\ToPhone\极简欧洲史'
os.chdir(path.decode('utf8'))
os.stat(u'.')
fn = os.listdir(u'.')
print(len(fn))
fileStat = []
for i in range(len(fn)):
    fileStat.append((i, os.stat(fn[i])) )
sortedByCreate = sorted(fileStat, key=lambda x: x[1].st_mtime, reverse=False)


'''
    action:  pick 1 to indexFilename, 2 to undo
'''
action = 1  # 0 is no action, 1 to "indexFilename" or 2 to "revertIndexFilename"

if action == 1 : #"indexFilename"
    for i in range(len(sortedByCreate)):
        num = "{:0>3d}".format(i+1)
        newFilename = num + fn[sortedByCreate[i][0]]
        os.rename(fn[sortedByCreate[i][0]], newFilename)
elif action == 2: # "revertIndexFilename"
    for i in range(len(fn)):
        newFilename = fn[i][3:]
        fileIndex = fn[i][:3]
        #print(newFilename)
        #print(fileIndex)
        if (isInt(fileIndex)):
            os.rename(fn[i], newFilename)
os.listdir(path.decode('utf8'))
