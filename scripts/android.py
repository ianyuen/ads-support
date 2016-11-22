import os
import sys
import setEnv
import config

projectPath = '../app'

gradleVersion = '2.2.0'

def StartDDMS():
	command = os.environ['ANDROID_TOOLS'] + 'ddms'
	os.system(command)
	raw_input('\nPress any key to continue')
	Support()

def CreateProject():
	command = os.environ['ANDROID_TOOLS'] + 'android create project --target android-' + config.TARGET_API + ' --name ' + config.APP_NAME + ' --path ' + projectPath + ' --activity Splash --package ' + config.APP_PACKAGE + ' --gradle --gradle-version ' + gradleVersion
	os.system(command)
	raw_input('\nPress any key to continue')
	Support()

def InstallAPK():
	if config.RELEASE == 0:
		build = 'debug'
	else:
		build = 'release'
	command = os.environ['PLATFORM_TOOLS'] + 'adb install -r ' + projectPath + '/build/outputs/apk/app-' + build + '.apk'
	os.system(command)
	raw_input('\nPress any key to continue')
	Support()

def MakeAPK():
	if config.RELEASE == 0:
		build = 'debug'
	else:
		build = 'release'

	os.chdir(os.getcwd() + '/' + projectPath)
	command = os.environ['GRADLEW'] + ' assemble' + build
	os.system(command)
	raw_input('\nPress any key to continue')
	Support()

def ClearScreen():
	os.system("cls")

def Support():
	ClearScreen()
	print '1 - make apk'
	print '2 - install apk'
	print '3 - start DDMS'
	print '4 - create project'
	print '5 - exit'

	value = raw_input('Enter your choose: ')
	if value == '1':
		MakeAPK()
	elif value == '2':
		InstallAPK()
	elif value == '3':
		StartDDMS()
	elif value == '4':
		CreateProject()
	elif value == '5':
		print 'bye bye'
	else:
		Support()

def __main__():
	Support()

__main__()