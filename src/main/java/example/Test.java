package example;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context; 

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Comment
 *
 */
public class Test implements RequestHandler<Request, Response>
{
    public Response handleRequest(Request request, Context context)
    {

        /*File dir = new File ("/home/"+System.getProperty("user.name")+"/.kettle");
        File file = new File (dir +"/kettle.properties");

        try
        {
            if (!dir.exists())
                dir.mkdir();
            if (!file.exists())
                new FileOutputStream(file).close();
            file.setLastModified(System.currentTimeMillis());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }*/

        try {
            File file = new File("/tmp/helloworld.ktr");
            FileWriter fileWriter = new FileWriter(file);
            String ktr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><transformation>   <info>     <name>helloworld</name>     <description/>     <extended_description/>     <trans_version/>     <trans_type>Normal</trans_type>     <trans_status>0</trans_status>     <directory>&#x2f;</directory>     <parameters>       <parameter>         <name>param1</name>         <default_value/>         <description/>       </parameter>     </parameters>     <log>       <trans-log-table>         <connection/>         <schema/>         <table/>         <size_limit_lines/>         <interval/>         <timeout_days/>         <field>           <id>ID_BATCH</id>           <enabled>Y</enabled>           <name>ID_BATCH</name>         </field>         <field>           <id>CHANNEL_ID</id>           <enabled>Y</enabled>           <name>CHANNEL_ID</name>         </field>         <field>           <id>TRANSNAME</id>           <enabled>Y</enabled>           <name>TRANSNAME</name>         </field>         <field>           <id>STATUS</id>           <enabled>Y</enabled>           <name>STATUS</name>         </field>         <field>           <id>LINES_READ</id>           <enabled>Y</enabled>           <name>LINES_READ</name>           <subject/>         </field>         <field>           <id>LINES_WRITTEN</id>           <enabled>Y</enabled>           <name>LINES_WRITTEN</name>           <subject/>         </field>         <field>           <id>LINES_UPDATED</id>           <enabled>Y</enabled>           <name>LINES_UPDATED</name>           <subject/>         </field>         <field>           <id>LINES_INPUT</id>           <enabled>Y</enabled>           <name>LINES_INPUT</name>           <subject/>         </field>         <field>           <id>LINES_OUTPUT</id>           <enabled>Y</enabled>           <name>LINES_OUTPUT</name>           <subject/>         </field>         <field>           <id>LINES_REJECTED</id>           <enabled>Y</enabled>           <name>LINES_REJECTED</name>           <subject/>         </field>         <field>           <id>ERRORS</id>           <enabled>Y</enabled>           <name>ERRORS</name>         </field>         <field>           <id>STARTDATE</id>           <enabled>Y</enabled>           <name>STARTDATE</name>         </field>         <field>           <id>ENDDATE</id>           <enabled>Y</enabled>           <name>ENDDATE</name>         </field>         <field>           <id>LOGDATE</id>           <enabled>Y</enabled>           <name>LOGDATE</name>         </field>         <field>           <id>DEPDATE</id>           <enabled>Y</enabled>           <name>DEPDATE</name>         </field>         <field>           <id>REPLAYDATE</id>           <enabled>Y</enabled>           <name>REPLAYDATE</name>         </field>         <field>           <id>LOG_FIELD</id>           <enabled>Y</enabled>           <name>LOG_FIELD</name>         </field>         <field>           <id>EXECUTING_SERVER</id>           <enabled>N</enabled>           <name>EXECUTING_SERVER</name>         </field>         <field>           <id>EXECUTING_USER</id>           <enabled>N</enabled>           <name>EXECUTING_USER</name>         </field>         <field>           <id>CLIENT</id>           <enabled>N</enabled>           <name>CLIENT</name>         </field>       </trans-log-table>       <perf-log-table>         <connection/>         <schema/>         <table/>         <interval/>         <timeout_days/>         <field>           <id>ID_BATCH</id>           <enabled>Y</enabled>           <name>ID_BATCH</name>         </field>         <field>           <id>SEQ_NR</id>           <enabled>Y</enabled>           <name>SEQ_NR</name>         </field>         <field>           <id>LOGDATE</id>           <enabled>Y</enabled>           <name>LOGDATE</name>         </field>         <field>           <id>TRANSNAME</id>           <enabled>Y</enabled>           <name>TRANSNAME</name>         </field>         <field>           <id>STEPNAME</id>           <enabled>Y</enabled>           <name>STEPNAME</name>         </field>         <field>           <id>STEP_COPY</id>           <enabled>Y</enabled>           <name>STEP_COPY</name>         </field>         <field>           <id>LINES_READ</id>           <enabled>Y</enabled>           <name>LINES_READ</name>         </field>         <field>           <id>LINES_WRITTEN</id>           <enabled>Y</enabled>           <name>LINES_WRITTEN</name>         </field>         <field>           <id>LINES_UPDATED</id>           <enabled>Y</enabled>           <name>LINES_UPDATED</name>         </field>         <field>           <id>LINES_INPUT</id>           <enabled>Y</enabled>           <name>LINES_INPUT</name>         </field>         <field>           <id>LINES_OUTPUT</id>           <enabled>Y</enabled>           <name>LINES_OUTPUT</name>         </field>         <field>           <id>LINES_REJECTED</id>           <enabled>Y</enabled>           <name>LINES_REJECTED</name>         </field>         <field>           <id>ERRORS</id>           <enabled>Y</enabled>           <name>ERRORS</name>         </field>         <field>           <id>INPUT_BUFFER_ROWS</id>           <enabled>Y</enabled>           <name>INPUT_BUFFER_ROWS</name>         </field>         <field>           <id>OUTPUT_BUFFER_ROWS</id>           <enabled>Y</enabled>           <name>OUTPUT_BUFFER_ROWS</name>         </field>       </perf-log-table>       <channel-log-table>         <connection/>         <schema/>         <table/>         <timeout_days/>         <field>           <id>ID_BATCH</id>           <enabled>Y</enabled>           <name>ID_BATCH</name>         </field>         <field>           <id>CHANNEL_ID</id>           <enabled>Y</enabled>           <name>CHANNEL_ID</name>         </field>         <field>           <id>LOG_DATE</id>           <enabled>Y</enabled>           <name>LOG_DATE</name>         </field>         <field>           <id>LOGGING_OBJECT_TYPE</id>           <enabled>Y</enabled>           <name>LOGGING_OBJECT_TYPE</name>         </field>         <field>           <id>OBJECT_NAME</id>           <enabled>Y</enabled>           <name>OBJECT_NAME</name>         </field>         <field>           <id>OBJECT_COPY</id>           <enabled>Y</enabled>           <name>OBJECT_COPY</name>         </field>         <field>           <id>REPOSITORY_DIRECTORY</id>           <enabled>Y</enabled>           <name>REPOSITORY_DIRECTORY</name>         </field>         <field>           <id>FILENAME</id>           <enabled>Y</enabled>           <name>FILENAME</name>         </field>         <field>           <id>OBJECT_ID</id>           <enabled>Y</enabled>           <name>OBJECT_ID</name>         </field>         <field>           <id>OBJECT_REVISION</id>           <enabled>Y</enabled>           <name>OBJECT_REVISION</name>         </field>         <field>           <id>PARENT_CHANNEL_ID</id>           <enabled>Y</enabled>           <name>PARENT_CHANNEL_ID</name>         </field>         <field>           <id>ROOT_CHANNEL_ID</id>           <enabled>Y</enabled>           <name>ROOT_CHANNEL_ID</name>         </field>       </channel-log-table>       <step-log-table>         <connection/>         <schema/>         <table/>         <timeout_days/>         <field>           <id>ID_BATCH</id>           <enabled>Y</enabled>           <name>ID_BATCH</name>         </field>         <field>           <id>CHANNEL_ID</id>           <enabled>Y</enabled>           <name>CHANNEL_ID</name>         </field>         <field>           <id>LOG_DATE</id>           <enabled>Y</enabled>           <name>LOG_DATE</name>         </field>         <field>           <id>TRANSNAME</id>           <enabled>Y</enabled>           <name>TRANSNAME</name>         </field>         <field>           <id>STEPNAME</id>           <enabled>Y</enabled>           <name>STEPNAME</name>         </field>         <field>           <id>STEP_COPY</id>           <enabled>Y</enabled>           <name>STEP_COPY</name>         </field>         <field>           <id>LINES_READ</id>           <enabled>Y</enabled>           <name>LINES_READ</name>         </field>         <field>           <id>LINES_WRITTEN</id>           <enabled>Y</enabled>           <name>LINES_WRITTEN</name>         </field>         <field>           <id>LINES_UPDATED</id>           <enabled>Y</enabled>           <name>LINES_UPDATED</name>         </field>         <field>           <id>LINES_INPUT</id>           <enabled>Y</enabled>           <name>LINES_INPUT</name>         </field>         <field>           <id>LINES_OUTPUT</id>           <enabled>Y</enabled>           <name>LINES_OUTPUT</name>         </field>         <field>           <id>LINES_REJECTED</id>           <enabled>Y</enabled>           <name>LINES_REJECTED</name>         </field>         <field>           <id>ERRORS</id>           <enabled>Y</enabled>           <name>ERRORS</name>         </field>         <field>           <id>LOG_FIELD</id>           <enabled>N</enabled>           <name>LOG_FIELD</name>         </field>       </step-log-table>       <metrics-log-table>         <connection/>         <schema/>         <table/>         <timeout_days/>         <field>           <id>ID_BATCH</id>           <enabled>Y</enabled>           <name>ID_BATCH</name>         </field>         <field>           <id>CHANNEL_ID</id>           <enabled>Y</enabled>           <name>CHANNEL_ID</name>         </field>         <field>           <id>LOG_DATE</id>           <enabled>Y</enabled>           <name>LOG_DATE</name>         </field>         <field>           <id>METRICS_DATE</id>           <enabled>Y</enabled>           <name>METRICS_DATE</name>         </field>         <field>           <id>METRICS_CODE</id>           <enabled>Y</enabled>           <name>METRICS_CODE</name>         </field>         <field>           <id>METRICS_DESCRIPTION</id>           <enabled>Y</enabled>           <name>METRICS_DESCRIPTION</name>         </field>         <field>           <id>METRICS_SUBJECT</id>           <enabled>Y</enabled>           <name>METRICS_SUBJECT</name>         </field>         <field>           <id>METRICS_TYPE</id>           <enabled>Y</enabled>           <name>METRICS_TYPE</name>         </field>         <field>           <id>METRICS_VALUE</id>           <enabled>Y</enabled>           <name>METRICS_VALUE</name>         </field>       </metrics-log-table>     </log>     <maxdate>       <connection/>       <table/>       <field/>       <offset>0.0</offset>       <maxdiff>0.0</maxdiff>     </maxdate>     <size_rowset>10000</size_rowset>     <sleep_time_empty>50</sleep_time_empty>     <sleep_time_full>50</sleep_time_full>     <unique_connections>N</unique_connections>     <feedback_shown>Y</feedback_shown>     <feedback_size>50000</feedback_size>     <using_thread_priorities>Y</using_thread_priorities>     <shared_objects_file/>     <capture_step_performance>N</capture_step_performance>     <step_performance_capturing_delay>1000</step_performance_capturing_delay>     <step_performance_capturing_size_limit>100</step_performance_capturing_size_limit>     <dependencies>     </dependencies>     <partitionschemas>     </partitionschemas>     <slaveservers>     </slaveservers>     <clusterschemas>     </clusterschemas>     <created_user>-</created_user>     <created_date>2017&#x2f;04&#x2f;25 10&#x3a;11&#x3a;28.925</created_date>     <modified_user>-</modified_user>     <modified_date>2017&#x2f;04&#x2f;25 10&#x3a;11&#x3a;28.925</modified_date>     <key_for_session_key/>     <is_key_private>N</is_key_private>   </info>   <notepads>   </notepads>   <order>     <hop>       <from>Data Grid</from>       <to>Get Variables</to>       <enabled>Y</enabled>     </hop>     <hop>       <from>Get Variables</from>       <to>Write to log</to>       <enabled>Y</enabled>     </hop>   </order>   <step>     <name>Write to log</name>     <type>WriteToLog</type>     <description/>     <distribute>Y</distribute>     <custom_distribution/>     <copies>1</copies>     <partitioning>       <method>none</method>       <schema_name/>     </partitioning>       <loglevel>log_level_basic</loglevel>       <displayHeader>Y</displayHeader>       <limitRows>N</limitRows>       <limitRowsNumber>0</limitRowsNumber>       <logmessage/>     <fields>       <field>         <name>msg</name>         </field>       <field>         <name>param1</name>         </field>       </fields>     <cluster_schema/>     <remotesteps>       <input>       </input>       <output>       </output>     </remotesteps>     <GUI>       <xloc>512</xloc>       <yloc>192</yloc>       <draw>Y</draw>     </GUI>     </step>    <step>     <name>Data Grid</name>     <type>DataGrid</type>     <description/>     <distribute>Y</distribute>     <custom_distribution/>     <copies>1</copies>     <partitioning>       <method>none</method>       <schema_name/>     </partitioning>     <fields>       <field>         <name>msg</name>         <type>String</type>         <format/>         <currency/>         <decimal/>         <group/>         <length>-1</length>         <precision>-1</precision>         <set_empty_string>N</set_empty_string>       </field>     </fields>     <data>       <line> <item/> </line>     </data>     <cluster_schema/>     <remotesteps>       <input>       </input>       <output>       </output>     </remotesteps>     <GUI>       <xloc>192</xloc>       <yloc>192</yloc>       <draw>Y</draw>     </GUI>     </step>    <step>     <name>Get Variables</name>     <type>GetVariable</type>     <description/>     <distribute>Y</distribute>     <custom_distribution/>     <copies>1</copies>     <partitioning>       <method>none</method>       <schema_name/>     </partitioning>     <fields>       <field>         <name>param1</name>         <variable>&#x24;&#x7b;param1&#x7d;</variable>         <type>String</type>         <format/>         <currency/>         <decimal/>         <group/>         <length>-1</length>         <precision>-1</precision>         <trim_type>none</trim_type>       </field>     </fields>     <cluster_schema/>     <remotesteps>       <input>       </input>       <output>       </output>     </remotesteps>     <GUI>       <xloc>352</xloc>       <yloc>192</yloc>       <draw>Y</draw>     </GUI>     </step>    <step_error_handling>   </step_error_handling>   <slave-step-copy-partition-distribution>   </slave-step-copy-partition-distribution>   <slave_transformation>N</slave_transformation> </transformation>";
            fileWriter.write(ktr);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            KettleEnvironment.init();
            TransMeta metaData = new TransMeta("/tmp/helloworld.ktr");
            Trans trans = new Trans( metaData );
            trans.execute( null );
            trans.waitUntilFinished();
            if ( trans.getErrors() > 0 ) {
                System.out.print( "Error Executing transformation" );
            }
        } catch( KettleException e ) {
            e.printStackTrace();
        }
        //String greetingString = String.format("Hello %s %s.", request.firstName, request.lastName);

/* example input is: 
{
  "firstName":"value1",
  "lastName" : "value2"
} 
*/
        return new Response("Done");
    }

    /* Just for testing */
    /*public static void main( String[] args )
    {
        try {
            KettleEnvironment.init();
            TransMeta metaData = new TransMeta("helloworld.ktr");
            Trans trans = new Trans( metaData );
            trans.execute( null );
            trans.waitUntilFinished();
            if ( trans.getErrors() > 0 ) {
                System.out.print( "Error Executing transformation" );
            }
        } catch( KettleException e ) {
            e.printStackTrace();
        }
    }*/
}