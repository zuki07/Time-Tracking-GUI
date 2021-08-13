<h1>Time-Tracking-GUI</h1>

<h2>Description</h2>
<p>This application helps keep track of the time spent on projects.  Let it be personal or business.  The projects are ordered by types.  A type of project could be programming, web, mechanic, and so on.  Each type of project can have multiple projects with unique names.  While working on a single project, start and end times are logged to a database.  This database can be local on a computer or on a server.  If you have multiple computers with this program, each computer can be linked to the same server to add or retrieve data.  This allows you to access the same information across multiple computers.</p>

<h2>Technologies Used</h2>
<ul>
  <li>This application is written in Java Swing.  I used Swing so the .jar file could be ran without having to open an IDE every time it is used.
  </li><br>
  <li>In the program are multiple frames including error handling and confirmation.  Any exception that is thrown will be displayed in its own frame.  Confirmation frames allow the user to select yes if a button click was meant or no if a click was made in the wrong place.
  </li><br>
  <li>There are three separate classes.  One to handle the SQL connection to the remote database.  Another to handle time events.  The last to execute quires to the database.
  </li><br>
  <li>
  The database configuration, such as database name, user name, password, server name and port are all saved to a local file.  This allows the program to use this information on each start up eliminating the need to set this up every time.
  </li><br>
  <li>Maps are used for retrieving data from the database.  This allowed me to have a value related to a specific key.  On some of the maps, the values are also maps allowing me to hold multiple sets of data inside a single map.
  </li><br>
  <li>Projects and project data are displayed using Java Swing Tables.  The project data table can be printed out on paper.  This allows the user to print start times, end times, dates and duration spent on that project.
  </li>
</ul>

<h2>The Challenges</h2>
<p>I had many challenges to overcome with this program.  While I was familiar with Java Swing, I learned how to:
  <ul>
    <li>Read and write maps to a .dat file.</li>
    <li>Establish a connection to a remote SQL server.</li>
    <li>Insert and delete records in a remote database.</li>
    <li>How to style Swing Tables for elegant UI.</li>
    <li>Print a hard copy of Swing Tables using the built in print dialog.</li>
  </ul>

<h2>How to Install</h2>
  <ol>
    <li>Click on CODE in this repository to open the drop down menu.
    </li>
    <li>Click on the download.zip file to download the program.
    </li>
    <li>Once downloaded, unzip the file.
    </li>
    <li>You can open the program in your IDE of choice and run it or open the dist folder and click on Time_log.jar to run the program.
  </ol>

<h2>How to Use</h2>
  <ol>
    <li>Open the README-2.TXT to copy and paste the sql query in your server control panel for your database. This will properly setup your database with the required tables and fields.
    </li>
    <li>On the very first run of the program, you will receive and error.  You will have to click on the CONFIGURE button to add in your database name, user name, password, host and port.  
    </li>
    <li>Click the +/- button to add a project type.
    </li>
    <li>Type in a project type and click INSERT.
    </li>
    <li>Near the bottom, type in a project name and click ADD.
    </li>
    <li>Repeat this process to add as many types and projects as you would like.
    </li>
    <li>To open a project to track time spent on it, click on the OPEN next to the desired project.
    </li>
    <li>Once the project is open, clicking on the START button will start and display the started time.
    </li>
    <li>To end the time, click on STOP. The stop time will be displayed along with a new row in the table.  This information will also be inserted into your database.
    </li>
  </ol>
  <p>More info with pictures about using this program can be found <a href="https://zuki07.github.io/Time-Tracking-GUI/">HERE</a>.</p>
<h4>Deleting Types, Projects and Data</h4>
  <ul>
    <li>To delete a project type, click on the +/- button at the top of the main window.  Enter in the desired type to be deleted and click on DELETE.  BE AWARE that deleting a type of project will also delete all projects and times associated with that type.
    </li>
    <li>To delete a project, enter in a project to delete near the bottom of the main window.  Click on DELETE and that single project will be deleted along with all the times associated with it.  Another way is to click on the project name you wish to delete in the table.  It will he highlighted in red.  Clicking on DELETE will delete the highlighted project.
    </li>
    <li>To delete a single time, open a project and click on the row of information that you wish to delete.  Once its highlighted, click on the DELETE button at the bottom of the window.  This will delete a single row and update the total times as if that row never existed.
    </li>
    <li>Any delete will also remove them from the database.  Once any delete has been confirmed, it cannot be undone.
    </li>
  </ul>
