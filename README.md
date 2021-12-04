# selenium-ratemylandlord
Selenium test cases for ratemylandlord project.

Note: You have to have Chrome installed.

The jar files you need are these (I already have them in the lib folder):
- Selenium: https://www.selenium.dev/downloads/
- Junit: https://search.maven.org/search?q=g:org.junit.jupiter%20AND%20v:5.8.2

Open the project in Visual Studio Code

The java file is in selenium-tests/src/AutomationFramework

Change the directory in the ratemylandlord_test.java file in line 24 to wherever you put the repository (this is for chromedriver):

![image](https://user-images.githubusercontent.com/91094317/144691274-4f0cea98-0e37-454d-8bad-f9aa48ddc99d.png)

You also need to add the jar files to the classpath here in VS Code (should be at the bottom left of the window):

![image](https://user-images.githubusercontent.com/91094317/144691919-a228d918-f1db-43d3-80d7-3c02f0649611.png)

Add the jar files for selenium and junit from the lib folder:

![image](https://user-images.githubusercontent.com/91094317/144691977-773443ef-00cb-4a70-aec0-0d2a3b692aef.png)

Also, go to settings.json in ```selenium-tests/.vscode``` and add the file paths to the jars in the lib foldier:

![image](https://user-images.githubusercontent.com/91094317/144692312-17712fee-7c74-465d-89e9-56a85c5cda78.png)

Compile the React end of ratemylandlord. (```npm run dev``` in ```ratemylandlord/rate_my_landlord/frontend```)

For the Django end, cd into ```ratemylandlord/rate_my_landlord``` in another terminal window

Use the command ```python3 manage.py flush``` to clear out the SQL file ```db.sqlite3```, which stored all the previous data you input (Don't do this if you want to keep your data you input previously, but it will mess with the test cases)

Now you can run the website: ```python3 manage.py runserver```

Now, run the code ```ratemylandlord_test.java``` in VS Code, and the tests should run. 


