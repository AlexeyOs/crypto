package ru.hc128.util.IO;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Output {


    public void rewriteEncryptFile(String pathToFile,byte[][] b) {
        //каждый новый массив с новой строки
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < b.length; i++) {
                for(int j = 0; j < b[i].length; j++) {
                    stringBuffer.append(b[i][j] + ",");
                }
                stringBuffer.append("\r\n");
            }
            System.out.println(stringBuffer);
            fileWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //ПЕРЕПИСАТЬ c OUTPUTSTREAM
    //-97,30,-83,96,76,-95,24,62,-127,92,67,109,25,-122,110,113,-47,65,98,52,34,127,89,73,-53,99,-121,-115,48,-108,-48,-35,86,-111,-66,32,-40,75,19,83,54,-52,-97,39,-3,11,119,69,-16,90,-13,-127,23,19,-82,112,-57,-67,-102,-33,38,-66,82,86,-73,11,-54,120,93,-42,-30,2,-103,-42,56,25,-98,-48,-77,0,28,-80,-11,-85,-128,-82,-123,47,50,102,28,11,60,-2,7,-102,-21,92,44,-54,-36,-13,45,-68,-34,56,-36,-99,92,-93,-102,-119,46,124,-27,-98,-104,111,-18,-92,-84,109,55,-101,116,86,-46,-95,81,111,-97,104,-36,-32,-43,94,58,-64,78,-44,-98,-7,64,-93,-29,-99,75,-125,-108,109,95,98,80,86,116,114,-49,-11,-127,-66,-55,35,-127,-35,-18,7,-79,-58,-48,18,-108,117,70,117,13,114,58,12,-17,-75,-39,-69,15,13,18,118,-80,53,-99,-101,47,-121,-31,111,-114,21,-65,74,-8,-19,24,-108,-29,47,52,6,-16,21,-99,-55,11,14,-50,-78,16,-44,69,-35,-75,-44,61,116,-93,-97,-9,55,67,-17,-93,-23,-67,21,-62,-29,-103,97,122,5,-76,52,-84,96,27,119,123,-101,-11,43,67,-96,-82,44,-34,62,38,-11,-4,-76,118,-14,121,75,107,82,76,-1,103,-2,47,-65,100,99,-55,56,-28,-62,-67,-90,49,-57,-97,-72,27,54,-112,29,-81,7,-84,123,109,56,88,-110,60,-2,102,41,-49,-36,-98,-128,71,-92,72,-18,101,-32,77,-110,-68,-97,-10,1,-124,17,102,108,-60,19,73,-80,-113,-55,113,67,36,58,32,-77,-111,-19,-97,-14,-100,38,114,95,57,49,68,-61,-62,-40,64,110,-100,-32,49,36,-121,109,-106,-98,-50,-105,72,126,-27,-65,-101,-110,52,-19,-75,-85,100,39,2,102,-23,13,111,-126,-14,19,-45,125,-24,-67,-120,73,-109,-118,93,87,118,-57,2,-79,111,-67,90,106,91,114,-52,-26,-106,-9,-85,78,-126,-77,-77,53,-55,65,113,93,-102,-58,-113,2,59,-66,68,-74,87,97,-84,-59,-41,-45,103,-51,68,86,54,119,111,92,46,-98,-94,-115,63,-9,-7,120,79,52,18,40,85,22,-15,51,74,-5,45,51,-53,-19,21,-114,60,119,79,-63,-70,-27,81,-122,-12,122,-114,28,-70,-73,-23,98,105,-11,88,-76,67,-67,-83,100,127,-80,25,-9,27,-26,13,-6,-5,-100,18,59,17,-15,51,-120,-107,-95,92,-39,-51,14,126,-110,13,-96,11,28,86,-61,118,23,-24,-57,-62,22,94,87,-87,72,-34,-115,-64,30,29,-120,-44,-109,-125,10,16,-84,86,-31,29,92,-52,-82,-63,-102,77,-28,-109,-82,-66,122,74,-29,116,-52,-110,-91,106,29,97,-105,41,10,88,-6,-95,65,41,66,-13,-43,-77,-112,107,15,-28,-126,56,85,-5,-124,-65,86,-102,-111,-112,-60,-5,27,61,42,-97,95,56,-61,88,89,-84,69,-66,-22,74,36,-19,-47,97,105,-2,-87,88,-55,114,-89,118,-10,59,88,-48,90,36,-122,-118,88,17,44,36,58,-38,115,-67,112,7,75,-81,127,15,18,88,-4,64,75,-70,15,-37,-121,91,102,-100,13,-89,77,116,-56,110,23,-16,118,89,-97,23,112,-123,-82,47,-96,126,-96,-9,-96,-31,-127,66,-94,78,-26,46,93,-10,-125,-113,25,58,88,13,-4,100,34,46,-29,-35,-18,-128,29,80,34,83,-19,-35,98,38,-38,-37,100,53,-80,83,-114,-96,18,-22,118,-53,96,-33,36,73,-72,-73,-64,-27,-83,122,-62,-8,-101,-20,54,67,63,-75,-125,-86,66,-84,-19,-5,117,108,-72,58,-58,107,-6,-102,124,92,9,59,-10,-19,-85,26,-72,7,40,10,31,24,-49,21,50,-120,121,-101,-34,-30,-50,25,-125,73,6,28,-101,109,-8,-105,-55,-77,-17,-87,-61,-95,-127,-61,-68,-19,-6,39,8,79,117,26,73,-55,-79,-80,48,49,19,-18,1,120,88,72,-2,-79,65,11,-73,119,126,44,17,67,101,-62,124,-15,-97,-8,10,114,119,124,-43,50,-85,-85,107,-13,-43,-35,-52,17,-24,-26,-123,-75,92,-15,69,101,-45,71,-90,28,66,-53,-123,-15,-103,51,-1,18,-19,115,-32,-86,-70,123,-73,-101,66,21,-21,-55,37,-52,93,81,124,-96,-61,42,-85,-70,-98,-44,-71,54,57,2,93,-103,32,84,-56,-28,-98,-108,97,-16,105,0,95,-20,49,-111,37,-20,75,-41,90,-87,102,68,-89,28,43,125,-12,-57,46,113,17,-107,-101,0,83,-126,95,-95,-32,-55,100,-123,-33,-95,70,9,88,-15,67,-15,-21,-106,99,-29,-51,67,-30,-74,63,-83,-16,-26,-21,89,-60,19,122,70,23,8,78,-34,-84,115,113,-73,-97,-36,-100,76,-34,53,102,114,68,-37,29,85,-61,84,102,-92,-94,70,67,-109,-81,90,-121,-22,11,-114,-112,-105,-11,-18,-35,-22,-86,61,-113,-115,15,-72,-86,-42,94,-15,-25,-17,-18,-28,127,-84,22,-17,-69,-45,-120,-69,-82,9,124,-7,-116,72,71,-127,-85,-27,-88,-59,79,-110,-61,127,34,85,-127,16,70,-57,105,74,80,86,45,-25,60,-115,-31,-91,16,42,86,52,7,82,-119,75,-64,125,13,98,98,-32,75,-13,-84,72,-115,-85,-56,39,-51,121,120,-16,45,85,-11,-67,-51,33,25,-77,0,26,-123,86,-85,-107,-3,40,61,44,85,84,-123,-35,-111,40,102,98,107,35,98,92,-40,64,99,-103,3,49,-56,-5,63,43,33,-7,-41,-41,47,98,-108,-4,81,-5,-113,110,-19,-120,63,-105,-97,-52,117,27,-121,74,-43,97,65,98,40,76,-35,90,-39,-69,6,61,36,-97,101,-84,-82,-22,-78,103,11,-118,100,-106,-52,117,-80,-107,127,-38,87,-75,-74,13,-27,7,88,-110,-22,-39,23,-94,93,-40,-79,81,-53,21,80,-11,-39,-5,8,66,90,-88,77,124,51,-106,96,112,18,60,-12,-13,-93,-28,-92,32,-38,-28,-23,117,-30,-4,-115,-62,-26,-19,28,-88,-23,78,118,-65,39,-115,18,-10,125,-79,68,-77,125,47,56,109,61,-15,-21,-102,-21,43,-69,-16,-65,-56,85,38,-98,-72,-59,-87,67,-22,48,-61,64,106,-119,46,10,-11,-43,-107,-60,122,121,-56,-33,66,-67,-105,15,-57,40,100,-83,-24,-10,29,62,-64,-55,-64,-84,15,4,44,-44,96,-118,-77,18,-46,22,26,121,113,-42,-101,82,-74,82,-95,76,-17,-15,56,5,-117,-123,-38,103,-72,98,104,110,-3,-113,-118,-123,-127,-111,-80,0,-88,63,25,-40,-106,-13,-112,-110,72,-77,111,-5,-16,36,15,55,-110,-49,34,-75,-50,-79,92,6,-38,-45,-59,90,-107,-14,24,122,43,-56,-80,107,-40,125,-50,109,-27,-6,65,-127,97,-52,-86,-15,-30,24,23,-92,30,26,-77,-2,-50,-5,-82,57,6,118,-89,109,-74,-58,1,98,11,113,52,-73,30,-98,-68,-74,-58,125,-37,-73,-29,80,44,33,-4,-56,-68,9,48,-53,-2,73,-40,115,41,61,118,84,-53,106,-104,-89,-78,88,-98,73,39,-35,-55,-51,63,118,-86,84,4,-128,-52,97,65,-52,16,58,-106,-106,11,-5,-117,-118,-23,27,1,-60,57,33,75,-100,60,-1,48,-22,-12,61,-88,-111,-57,-51,121,-53,26,-90,-66,72,-123,109,-126,23,-35,35,-19,42,-82,97,-80,-44,11,-106,10,50,-104,-84,-113,-46,-50,0,95,116,10,19,14,-10,87,-116,9,105,-24,-99,-31,80,37,-89,-113,-28,-15,-118,-77,-16,-8,-81,40,-79,-35,39,-111,121,-55,62,-22,103,20,-68,-116,-84,-11,125,-58,103,40,16,121,-75,-47,-74,-124,-4,100,-51,-84,122,32,114,-95,-38,-101,-43,-122,-97,70,31,-2,-17,-45,87,-56,-27,121,-51,39,46,49,11,-20,6,122,-48,-85,47,-52,-39,94,78,16,110,-61,21,-92,4,35,-16,-10,64,-101,-36,-25,40,-54,-127,105,18,88,104,87,-99,-113,15,-60,-77,-42,78,120,73,-36,-60,61,-115,-122,-6,2,-19,88,87,-46,20,-61,-30,-38,48,-124,104,-28,-51,50,26,-57,67,24,55,100,-14,117,13,45,90,80,-15,66,-57,-4,118,72,-30,111,73,2,32,-59,-108,10,-26,-7,123,-99,104,-35,-27,-77,93,14,24,-82,93,-20,10,-28,-102,-4,-72,72,31,59,89,-67,-122,-88,124,63,-46,-10,-127,27,23,2,8,32,-119,-107,-46,-79,50,21,-69,-58,65,-76,-15,91,32,55,-69,96,-48,-94,-67,-101,-67,104,-96,-4,95,-99,98,110,91,93,-22,-101,88,-14,115,75,9,17,-43,34,-56,-89,35,-60,16,-63,-48,96,-33,85,85,-118,63,-12,-61,-91,125,35,77,76,98,-12,-92,-99,-81,61,-107,-26,-123,74,8,-52,18,-106,68,20,7,-125,-90,-112,61,-64,-96,-102,38,118,-64,-102,55,99,36,-49,-79,-16,46,-124,-121,-92,30,-87,70,-84,-52,66,127,-33,-115,69,-44,-9,72,67,-44,65,55,-39,48,117,79,-21,60,40,76,-107,-107,-118,-111,47,12,16,-72,-57,74,-68,109,72,11,17,17,45,94,-34,67,8,-15,117,48,70,55,68,-28,3,80,9,80,-69,83,112,-43,-35,103,42,85,-29,65,115,-11,-59,-82,32,-90,45,48,-11,-80,-12,110,-48,-15,-40,-81,-64,65,56,-66,-71,5,8,-70,80,-75,-114,4,-101,-104,-45,92,-93,-36,-92,49,76,111,-54,-113,44,-35,0,-98,-97,116,-7,-106,108,-120,64,49,106,-13,-57,-114,21,89,-66,8,117,-26,96,89,76,-104,-76,62,72,-72,71,4,-13,7,-90,-5,8,-63,-72,2,121,-14,87,2,-98,-37,-35,-91,60,-84,88,63,32,10,13,-43,79,-37,-15,-93,103,93,20,-50,97,94,126,54,-58,47,115,32,27,-41,-28,3,-118,89,-117,-94,-62,-13,120,31,-12,103,23,-23,-79,121,83,50,74,-45,62,33,-20,58,88,-38,106,37,-94,-118,-118,-63,-88,96,-86,-67,16,-73,67,-68,-31,-43,-99,-121,97,-76,123,29,6,-73,-21,58,56,102,-31,-43,38,22,101,104,-51,60,107,108,22,-113,79,110,-59,55,43,-25,55,20,-100,59,96,74,90,99,123,-79,106,-125,-40,86,-71,-22,105,-88,-79,-7,-102,1,-82,120,-97,-20,9,28,-120,57,13,-101,101,53,-115,39,89,83,-113,-34,-40,116,37,-123,27,72,104,120,107,-106,10,30,122,-53,-16,-61,-28,17,-24,62,-36,66,-100,-122,-98,19,-82,-95,114,-24,15,13,122,20,93,-125,-83,-127,-56,-48,-89,-66,-29,1,-76,-89,-36,10,-77,-102,96,14,-36,113,52,94,53,-62,58,-120,113,-128,10,-2,120,86,91,-20,-80,-114,-10,-126,114,71,-101,6,-52,-30,81,101,41,100,31,-56,-118,-119,-86,126,12,21,-25,96,44,122,-18,42,112,-69,-81,94,69,39,-119,-7,41,38,-31,-89,-11,-94,28,-45,-60,123,110,110,-20,-80,-83,14,-2,111,68,20,-9,93,-19,5,101,12,-47,-9,114,-110,123,18,-120,-112,-34,91,-64,-98,88,15,-121,31,36,77,-21,58,127,98,-16,-69,121,-43,-111,-97,67,-53,97,-60,104,35,73,-12,50,-107,43,-40,70,-49,-64,0,108,111,52,-115,-22,-61,-90,-48,1,83,25,-110,116,-69,-37,-46,88,-111,125,-67,-63,114,-103,-40,48,99,-74,-122,-19,104,-12,-110,7,100,-58,-113,-116,-76,-7,47,126,106,103,111,127,94,123,113,115,-13,15,-108,-123,-88,67,54,-98,106,29,-126,48,-35,65,8,115,124,-81,5,-40,-47,75,-31,21,-64,3,-111,-5,115,101,-54,-67,3,113,-61,59,3,1,-1,-74,-59,-34,-31,39,-105,-116,66,-24,47,-16,23,-127,31,-15,-54,1,-65,-109,45,26,-50,76,-110,107,-118,-92,-106,115,-100,118,-44,49,-94,18,70,-114,6,36,-39,43,30,51,-2,-98,-125,41,-115,35,118,-60,13,-79,-120,-86,-61,-98,91,-128,7,-18,82,83,-73,76,109,-63,-123,-38,80,100,-119,26,52,60,64,94,-61,35,-16,-73,113,76,43,-93,-100,-49,27,16,-95,-54,-37,17,-27,82,34,95,108,-57,-78,-90,59,54,-121,-38,-2,44,-53,-36,110,99,-122,-116,17,110,55,-14,-68,-77,84,-6,-74,-23,-79,26,126,-102,-68,-71,60,-119,16,-114,116,-36,-80,90,115,86,-15,-103,-19,92,-40,45,10,72,98,-64,-51,-86,-24,0,-95,-53,98,-128,-77,-19,-48,-95,-51,91,-9,37,-35,-69,-8,-118,116,68,-84,79,-98,-88,-37,48,15,-11,91,-35,-118,-74,56,-79,70,33,-102,-4,71,31,-27,67,-115,-101,-8,121,13,-85,33,75,67,-74,102,120,-53,111,3,-57,-106,121,-109,-106,44,31,-96,110,-95,7,75,87,-91,-40,-61,-8,-23,-8,20,-3,-109,-113,-119,14,-52,35,50,98,-70,84,77,-98,39,-6,67,-8,0,65,113,64,-74,116,116,-34,-6,120,-23,64,-14,-92,-60,-30,89,-71,13,-101,-68,21,51,27,118,67,77,7,45,74,-90,105,0,73,-109,-123,63,75,16,-46,62,58,40,-3,-84,-112,-77,21,80,-74,-128,39,-127,-105,22,57,124,125,-8,-28,-22,-60,-18,-59,43,-122,-19,-108,93,0,-31,-55,-14,59,-48,107,3,-70,-113,-41,114,88,-87,-24,25,35,-94,-122,47,28,14,-109,96,100,-69,70,-48,39,-125,-33,52,28,-104,-85,2,-88,94,87,-28,-96,79,-66,-30,81,105,-20,-15,-81,104,-26,4,69,-17,116,-59,-82,-109,-36,30,96,69,95,-23,84,117,8,83,87,-126,-112,-18,-4,-50,-3,35,120,-124,23,36,51,119,99,-22,71,-122,-6,52,24,17,68,-13,-126,-31,-33,74,-107,-72,69,-127,-77,-52,-86,27,-15,27,-42,-109,-83,-46,104,86,-79,101,103,55,-39,-40,-5,-39,-21,-87,-27,-17,-70,-51,5,50,-22,-78,76,-122,-25,101,73,111,113,-44,-50,46,-57,1,24,-39,-110,111,14,4,119,-103,-37,15,-40,59,47,77,122,-87,52,47,-87,26,-105,74,16,-113,16,7,-36,112,95,-65,-37,-52,55,-34,-44,-107,-101,-55,-63,105,97,43,-108,10,47,-116,-124,68,19,-7,-95,-17,43,-64,-105,-27,125,-19,-102,2,92,-79,48,115,26,-31,-109,11,70,71,-3,-62,-114,21,84,66,38,18,34,-89,-39,53,10,121,123,110,-88,-41,-63,-88,2,33,30,111,-119,-79,-47,-62,-2,-7,-62,58,-64,101,37,-115,96,82,101,-66,61,-45,-26,26,-69,-75,31,-47,-27,-15,29,-43,69,-21,29,-39,-61,14,68,79,-51,65,-42,-73,-8,79,68,-28,89,10,-91,102,24,123,-4,99,71,125,-30,93,121,90,20,89,-113,20,27,-85,-42,85,70,-8,100,-108,-51,-125,-61,-2,4,-110,33,115,-49,2,-26,-60,-45,-55,72,72,94,-118,126,3,-122,-109,-39,102,66,18,-71,75,-20,-110,58,69,-50,-118,-10,-102,-59,100,107,121,-95,86,115,-108,4,-100,55,71,55,-48,-98,-43,28,-46,27,-44,57,6,44,29,-7,-17,-117,-102,-102,-20,-112,-77,13,54,-98,68,-55,-6,23,72,108,88,-124,-26,111,82,58,19,-92,-54,-46,-87,-118,59,-88,89,124,-85,-117,-73,-109,-76,-5,-18,-110,-47,-47,-69,36,50,-47,-27,35,95,-11,-104,42,-111,-26,31,-29,32,-49,18,27,78,69,23,-41,-14,-21,13,108,79,55,114,27,-125,-15,-31,-82,28,96,-18,42,-118,50,13,-9,49,82,10,27,35,46,33,-16,125,-58,-116,125,-56,-32,1,99,-73,-83,127,107,21,-40,-4,115,-20,-102,-86,105,39,27,116,-53,30,13,0,56,9,-61,103,95,64,-67,-34,-95,119,51,-119,-115,-99,105,-46,-15,-19,51,24,24,-30,14,3,-89,-61,-5,10,77,-7,-20,-122,91,-76,-36,-95,20,21,122,-15,-116,-115,-54,123,-108,124,-90,13,57,14,-74,18,56,37,16,-122,90,-16,-5,-66,16,81,49,-15,73,-5,22,-90,13,-84,-52,126,-121,-3,-88,-86,-127,-36,-5,-98,79,-85,69,-23,94,76,-37,-51,91,29,0,116,1,7,92,-90,-3,-125,98,19,-119,0,-2,36,-105,-25,-120,124,115,-9,-41,-43,41,3,119,-49,-128,59,-7,-25,-12,-45,-16,-96,46,87,-19,91,78,124,-22,79,-79,-116,-49,42,40,-60,-7,21,-62,-20,120,-10,-7,71,65,80,-117,0,17,-8,-107,91,13,46,95,-83,109,-36,91,-119,10,14,-16,-91,-94,-78,105,-78,-35,12,30,5,-101,-15,20,-123,-122,-75,-17,0,-35,80,-59,-23,-46,-85,9,91,81,-54,4,-57,98,43,-2,75,38,-80,50,87,6,-28,100,-95,-97,-9,-113,-52,-76,-2,27,-23,126,-13,63,4,59,64,-65,-105,-115,-40,83,-127,78,-87,-57,91,-26,-121,-79,-57,54,42,70,-35,93,4,-111,-82,2,25,-78,79,-126,-50,-34,-109,55,26,9,-78,-85,-111,-26,-75,123,-84,68,-12,81,120,-28,-1,-78,-20,21,110,23,3,-79,99,-96,-86,-39,-29,-38,-71,-40,24,66,-118,106,116,-102,-127,-37,-4,-48,-103,125,51,-125,99,54,33,109,101,121,122,0,-58,-124,-79,82,70,-13,-97,68,-2,-75,90,64,54,-46,-115,-58,41,101,-61,-78,-72,-60,123,118,-1,47,-83,-117,-107,45,69,-109,-70,12,-17,-51,32,-8,-45,35,91,65,-102,91,96,-14,-128,20,96,-61,13,105,35,-77,4,-48,-104,124,68,-111,42,-127,-68,-13,-77,81,27,49,46,119,81,-75,13,-48,60,116,71,101,101,17,93,11,-98,56,93,-23,73,51,-78,27,122,-75,25,112,119,-102,-26,-46,-87,106,117,84,-23,-78,12,-86,11,49,14,-100,-62,8,0,-76,-81,111,42,71,-32,-69,-9,-70,-64,85,-68,117,-4,-62,-45,-8,122,23,-36,56,-99,102,-84,-97,-12,14,22,-9,69,28,-1,-15,-40,103,-61,35,-99,-88,35,-68,116,61,-71,-67,-99,-90,-35,71,56,-51,-37,50,51,-118,55,40,-41,68,11,33,-64,-24,-25,46,-125,29,-65,-105,-22,-97,66,85,-41,-89,121,-83,112,-82,124,39,79,96,-59,-38,66,-88,-10,-109,64,-126,-25,-84,32,105,62,-88,28,109,-37,-63,-14,55,-119,7,-101,-74,-67,-6,-104,-80,-104,-101,-125,-112,98,-73,-96,36,34,-72,42,-58,-102,-46,65,-34,-118,118,23,62,54,-85,77,-27,71,25,74,-79,66,75,37,-84,-74,113,-78,15,-3,-3,94,86,33,89,45,116,-96,-5,-67,9,-29,-91,93,100,-31,9,89,50,-14,-123,116,-113,-119,-82,112,-23,-15,21,79,-53,-48,96,-108,-124,-17,53,-99,69,-72,-35,126,-36,96,-127,-33,-118,42,89,20,116,-95,5,59,66,-118,14,91,73,-74,-74,127,21,80,-88,3,-61,-38,-72,-92,90,21,-108,-50,-75,-11,1,-34,78,3,17,102,49,-87,90,19,-32,13,-117,-32,-39,43,61,74,12,-110,-94,126,114,-62,-2,-30,-104,-8,-42,-29,-85,-86,17,95,47,68,9,-88,-85,-46,52,-99,119,125,-25,-78,51,-63,56,-67,2,-11,16,45,15,-2,-105,-71,-36,116,72,-117,2,28,77,-36,-32,66,71,-64,75,112,45,-10,18,-119,-119,71,110,50,-6,-43,-81,91,-93,-35,-24,-24,77,106,-101,-97,-38,-102,-127,-18,-63,110,125,-104,73,103,45,-29,-81,-31,20,93,81,26,83,-16,-78,88,-126,36,115,-103,76,42,-105,-72,-111,-53,-68,51,-71,64,104,25,3,-116,-97,-13,-109,94,-30,98,34,-64,59,47,31,120,74,-106,-4,-3,106,-84,-59,-36,15,-63,-126,20,-55,-29,-40,-28,100,40,-5,-121,47,-3,13,55,72,-99,-99,-70,-110,-118,15,115,105,-55,38,-41,90,-78,-11,-53,-117,-34,30,65,112,91,-68,117,73,-6,92,17,15,29,74,-28,93,-23,-56,60,122,-90,116,-46,113,-23,56,103,-56,18,-59,66,125,-71,-72,35,-24,51,93,95,-52,79,56,-56,77,-64,55,16,32,10,10,68,-6,98,56,39,-53,-115,-88,-86,44,-100,2,117,104,77,6,-97,127,36,-55,59,61,-31,38,-94,58,25,89,70,47,-50,-93,-107,-98,21,23,45,84,-114,52,45,-116,95,1,70,-48,62,5,2,74,85,-120,-84,-31,-74,15,-60,98,124,23,-97,-96,-70,58,47,16,-103,0,-54,-95,-50,-81,-49,-123,-9,-119,49,-58,19,-45,-51,-73,-87,13,-28,86,-49,82,-37,-15,62,-95,-108,-106,-31,-13,-14,4,110,15,79,118,108,-77,18,-16,-69,37,97,4,-23,-66,9,-61,-3,90,92,64,-107,-51,-33,-12,-115,38,43,53,74,-70,-29,20,-18,-59,-100,-55,-23,19,47,52,-88,83,-33,-37,-70,85,98,1,-48,10,-80,125,-100,-60,56,-23,-14,51,-62,-40,124,-47,-125,-115,-110,-77,-38,59,53,100,108,27,84,-91,-14,40,-84,39,41,104,-32,42,-35,86,91,-67,67,2,-96,18,-7,93,-92,-123,28,-14,58,107,-111,-95,29,72,-77,98,-24,-60,103,90,-89,-66,85,54,-33,105,-127,118,-48,2,3,56,-75,108,29,-11,-104,-10,-81,20,32,-60,3,-59,88,-15,124,121,-111,-109,102,-90,123,45,23,1,-30,-21,-92,124,-87,28,31,36,88,72,32,-88,22,82,-84,-126,97,-18,-10,115,-13,-115,83,-117,-82,57,120,-21,102,-127,-64,-117,7,-37,107,41,-73,-128,-62,118,-110,97,58,121,-26,-94,39,85,-19,-102,51,24,-90,-91,-54,-45,-97,-93,39,-48,89,-71,-97,55,-52,90,-126,-109,77,60,21,65,123,-78,-76,-25,79,-85,124,85,-56,106,-2,41,46,13,16,57,92,107,58,117,72,48,-20,103,106,-32,-10,-112,-78,6,119,26,64,19,-61,55,-107,22,-64,-71,-27,-39,-126,-31,-124,56,19,-29,33,92,35,-86,108,90,8,-58,55,61,7,38,121,9,-8,86,29,109,83,-14,-28,20,-112,120,-118,74,-84,-36,-126,-33,-19,-46,-12,47,122,-22,-95,-112,-40,-12,31,49,47,-19,76,43,-76,-31,53,118,-19,116,-40,-93,-46,-82,-11,-93,77,64,-86,35,-7,28,-71,-15,118,123,-83,-114,-78,90,-16,-66,78,66,-125,-103,53,79,68,124,-51,-40,-69,78,81,40,64,-101,-35,-103,-36,-92,115,-48,-122,56,75,114,-82,93,-116,-7,37,60,106,-123,100,-16,-67,38,-65,-83,40,79,127,-1,117,-104,90,9,-37,122,60,43,-119,-125,29,-77,60,10,-14,-93,-97,107,88,122,124,-47,66,-70,-37,-27,87,-119,-52,-102,47,-73,29,-82,124,78,124,82,98,9,113,-52,107,105,-85,-87,-1,-109,41,-28,84,24,-45,-109,-103,69,85,-94,-116,-118,-95,108,-41,116,120,-57,-72,77,-16,-54,-34,17,-86,52,4,3,21,24,79,-39,78,77,-4,-73,73,-77,-13,-93,88,49,-34,95,-94,89,112,-31,-16,45,81,-3,29,-93,9,-83,-95,-29,-26,89,56,111,-24,9,-8,36,48,127,-66,-7,69,59,78,117,-114,-86,-23,-81,-44,125,-50,-114,-116,39,88,115,78,-62,-65,36,-69,53,-52,67,16,18,12,62,121,29,27,-51,111,-65,83,-45,122,31,-54,72,-6,52,1,102,28,-89,-118,72,97,-52,102,66,-113,21,-86,-24,-114,-115,-120,93,30,-34,120,-126,-61,-13,-58,-86,-18,91,-59,-53,102,50,-2,-32,-64,-73,-81,112,-108,-81,-64,-110,-25,91,117,-119,-125,92,-115,105,-51,-99,3,-49,100,37,118,11,-33,-48,-117,94,-111,-48,-64,102,-42,-47,-49,-5,-111,-74,86,-71,-111,-72,122,50,33,56,96,102,30,-95,-122,-1,-85,117,27,92,4,-64,-64,-37,-5,-84,-90,86,-97,85,-86,-119,11,-79,3,27,22,89,26,-11,-26,-89,98,28,30,-7,1,27,23,98,-35,-126,-57,-127,-51,28,-72,-84,37,-44,-18,-30,40,121,-16,-45,-3,18,100,-72,32,-1,17,-100,-6,66,76,-122,-98,93,-121,-2,-39,-105,45,31,-89,-50,-26,35,-90,30,-128,-41,121,-88,-55,-38,-44,-84,111,114,-104,57,44,-11,5,-24,-11,95,-27,-53,47,55,-39,109,-28,32,109,-34,-124,-126,119,-36,-19,116,76,31,-11,-55,22,23,-8,-22,104,-61,-117,-47,-68,-13,-23,-71,124,-34,-16,-27,84,77,24,-92,-40,-67,-76,5,-46,95,-75,50,115,-55,70,-96,-119,-53,-83,87,-37,120,-83,-12,-17,-63,-17,12,88,89,-116,42,3,36,-21,-84,20,37,47,126,-96,10,95,-48,82,-56,-59,66,-94,-77,76,43,16,-38,68,45,104,-49,109,7,-42,-41,-16,80,2,-110,-104,-67,52,110,-63,-69,-115,82,-124,-62,71,9,-46,-120,39,-52,-28,17,-61,-62,-57,45,-87,-45,-89,98,30,-14,-18,106,24,-51,-107,68,-103,-58,-6,93,67,34,94,-88,-41,-62,127,53,-91,3,11,-24,-90,-46,-20,59,65,-93,23,85,-107,127,-120,80,-37,58,-81,47,-99,85,-42,16,20,123,105,-25,-26,83,-18,-10,-127,88,78,-8,40,-17,58,-9,93,-59,-3,-82,38,6,26,52,-46,89,-12,4,-128,30,93,57,-60,-119,-15,-11,-6,77,-6,-117,-46,-68,104,-123,-95,44,112,115,-105,-85,-65,-32,81,65,113,-43,17,-54,115,-45,-25,-5,81,-60,-92,-25,-64,31,-63,-104,-93,-114,0,93,8,-122,-35,-61,29,55,90,91,97,-63,-91,-117,109,-10,-11,-119,48,-80,95,117,34,35,68,5,-43,-84,-34,16,-9,-22,50,-37,-69,49,-74,-39,32,83,3,-19,-5,-12,-110,-127,4,-28,43,73,63,-106,-36,-43,-65,60,24,64,112,115,-85,51,4,126,32,126,107,96,-62,68,54,-119,-82,-99,-15,14,-36,-1,64,-96,94,-117,45,-102,-120,112,3,56,-12,-109,-55,50,-50,104,-82,105,73,-60,115,-35,7,109,-89,-11,-122,66,-60,-97,-30,-119,117,104,-31,99,-73,72,12,10,6,26,-70,-105,-20,-77,-22,-25,-76,0,-16,-79,-67,36,-80,2,-38,-62,-36,-77,93,-123,58,-41,75,91,-53,60,78,31,40,-35,-62,8,58,91,92,-66,-11,103,-92,-68,-14,114,121,60,21,22,84,19,100,-95,35,25,53,46,18,-49,-13,-56,-10,20,-100,-105,51,-102,-65,98,-87,36,-47,-51,7,-20,24,106,-34,60,107,-78,-85,-38,-109,-84,-47,-72,-60,-99,-35,-3,127,-34,96,-62,-4,94,-83,-44,13,104,-101,62,61,-42,74,43,41,26,106,-25,-50,-100,96,-64,123,85,-89,-60,-38,-32,53,-115,22,-46,-128,82,-35,96,-13,-102,4,91,-98,14,126,-60,50,-43,-15,45,-102,1,10,-100,22,114,3,-116,63,-110,-54,-15,-96,-74,118,42,-15,-125,-81,-16,-87,80,-105,-24,62,45,-99,13,-76,-67,39,115,-31,38,48,81,-13,-1,-36,-31,-74,3,-19,-120,107,16,-21,122,-17,-66,53,-71,-81,-78,-45,-65,122,46,65,-29,34,87,82,-29,-20,58,-10,114,38,68,31,1,-104,-49,103,6,14,45,-70,91,-14,-122,59,77,30,-109,-4,39,79,-11,-88,-41,-45,59,29,68,-75,-105,-66,-71,-11,127,-1,-82,-40,24,68,106,-111,-72,-16,0,91,-35,15,83,-19,-2,-39,81,126,107,-50,-22,56,-121,-48,-64,-53,100,121,7,76,127,-66,57,-104,-38,-55,76,27,55,-92,-92,109,-47,94,-90,108,43,-93,124,-58,99,78,-115,18,-85,72,3,-18,-54,50,-70,-71,-27,-104,114,5,-57,18,-71,98,53,11,92,71,15,14,53,-35,-10,-29,116,71,-62,13,88,14,14,98,41,58,-30,-74,93,93,-31,-6,-31,-16,-74,56,96,-123,-58,70,-86,-86,74,-14,-89,9,19,88,-34,-43,101,122,103,76,-117,56,-42,107,-34,-49,-75,71,-119,-17,-16,98,94,-12,39,-116,1,34,-48,-53,-88,-29,110,60,20,54,61,-13,-19,44,-41,89,-126,109,-117,124,-70,78,-107,86,-83,-106,40,3,123,-103,56,60,-72,-28,-42,12,108,58,81,15,36,59,-117,-108,28,-89,35,-64,22,47,83,-93,-55,-12,-52,-108,-120,104,13,-37,47,69,122,105,-123,117,-80,-80,76,33,50,-60,42,-118,-4,34,25,121,119,-105,51,-11,-14,-127,23,-26,-9,-10,121,25,126,-90,-65,-123,-107,-24,-124,44,-119,94,2,-15,-86,13,39,64,74,-118,-7,51,-58,17,42,-45,-38,-90,127,-21,-36,122,-75,-88,-59,-113,74,61,56,75,-91,12,121,-31,63,109,119,122,-126,36,20,-77,19,-52,-35,106,54,122,49,53,-106,-82,-72,27,10,-79,-7,-33,81,-102,109,-57,-111,114,78,-29,87,-25,68,49,-37,10,62,-27,40,-82,-97,-109,-116,26,-20,123,-35,90,-107,-13,-83,108,-12,58,52,-73,-38,-86,-24,66,15,-7,-41,15,89,-1,63,-29,119,-121,-124,62,33,-50,27,39,73,-87,42,51,-118,52,-1,108,61,42,91,61,44,32,-42,101,103,104,-12,10,68,2,107,125,82,91,-41,-86,-120,86,-99,-74,25,26,113,-95,-92,-109,84,-14,103,119,97,-95,93,-96,45,-39,11,-14,-34,23,-90,-11,12,-26,-33,-5,-6,-47,96,20,-3,-23,4,-126,-1,95,56,65,8,-91,121,53,-87,-22,-114,66,-43,32,90,62,15,64,44,77,-59,103,-2,-114,95,-53,-59,-100,-32,-91,-120,36,-5,-126,105,39,-42,93,-23,87,-85,1,2,-39,79,35,-45,34,92,48,-93,75,6,8,119,1,80,76,21,17,28,102,-110,93,82,-53,47,-12,9,-2,-55,62,-122,46,2,-5,-125,6,-70,80,8,-13,9,-38,-33,-33,-127,37,119,37,-99,22,121,36,-72,51,122,82,-99,-4,91,-8,-82,-47,118,113,25,-47,-102,-56,-81,18,2,-25,76,124,91,22,-94,33,-16,47,-54,93,-13,117,50,20,-80,-19,-25,101,107,74,115,-95,-91,52,-38,-84,27,-44,36,-107,64,-9,-32,126,77,-78,5,24,63,-77,85,-94,84,-124,118,-78,-128,115,90,-23,-18,-109,93,25,72,-23,49,-107,59,8,-113,-105,18,-80,-45,-3,-58,-26,-93,-78,-122,86,105,-103,-123,-98,-114,77,23,-37,62,116,-41,90,-45,-50,-115,-95,101,95,-12,-94,92,25,107,-76,-70,90,20,-25,-41,-23,-90,-63,44,126,-4,48,-2,55,0,-107,-94,120,-126,-33,-70,-119,35,-110,-60,16,-123,122,99,-55,-3,-40,10,-76,59,-61,69,-50,-112,39,-32,19,-94,126,-97,-34,63,66,-43,47,-117,11,-106,-40,33,-50,108,-99,19,-73,-7,-48,6,-94,117,79,-86,56,119,60,-16,90,-122,67,-74,111,73,-108,-68,22,21,26,-19,-75,108,-20,-109,-40,117,111,122,85,-62,75,72,-109,-99,15,62,-90,-125,58,16,-42,-91,-89,-106,-92,78,-123,-116,76,68,-128,37,-17,10,93,35,-92,113,-55,80,-57,-41,19,-61,-122,-21,-84,-37,12,61,-7,115,77,6,12,-5,122,89,-93,18,73,-43,-61,125,4,37,-115,-74,94,87,-97,59,-73,-87,-80,96,39,62,-15,12,126,-31,9,102,2,30,118,47,79,2,-20,62,84,-76,63,79,86,-98,61,-44,73,-120,-63,-59,70,50,127,-52,66,-29,126,35,-73,-90,-37,20,69,21,-42,-33,21,73,20,38,51,67,-94,6,65,22,-95,-82,63,-57,-116,8,-8,11,-42,74,121,47,-19,9,-112,-106,5,-12,-99,59,56,45,66,-83,-10,65,-68,41,101,68,90,31,21,-39,78,-34,-7,-100,-86,-56,-85,77,-70,66,-115,109,-30,-112,17,38,-60,-92,-117,-4,-60,-123,-17,-37,-34,25,-37,66,83,34,23,126,84,104,-86,2,1,121,1,-67,-85,47,-25,-63,-85,124,115,99,-18,-103,74,7,-113,-91,104,-126,49,-60,113,-8,72,-91,79,-91,107,4,-56,66,-63,106,112,-60,-73,-69,62,-117,-77,14,69,-36,-53,106,5,118,-103,66,79,-70,-9,-98,85,-20,124,-90,-121,96,63,9,96,-83,-105,-62,34,36,-77,-120,102,33,91,53,-2,-18,101,-75,-124,126,-38,97,-28,-77,108,119,8,-68,49,83,49,-76,-14,50,-75,91,-23,-106,13,-104,86,-122,37,3,67,11,-54,51,14,114,112,-43,41,48,11,-94,-8,-104,-47,-28,-75,-103,42,-26,-32,14,29,-19,41,-26,-103,-112,-87,3,16,-102,113,39,-120,26,27,43,5,-114,-62,41,104,-1,53,3,52,-7,-92,14,112,71,-38,125,15,78,107,-80,-88,-92,-13,-96,-20,127,-107,-33,104,-89,120,-90,76,85,67,101,-10,21,-70,-62,-109,-32,-63,101,-46,-17,30,108,100,91,-30,123,-102,45,20,31,7,-112,21,5,-14,117,-8,-104,-61,-71,-15,-45,91,38,-7,-63,90,68,-22,-78,-109,113,82,-70,123,-63,-1,-84,-39,49,40,2,-18,-105,122,9,24,11,-108,103,115,-63,-70,76,-53,-123,8,3,-61,18,-62,62,93,111,57,-124,-38,-58,-62,-78,57,14,-7,-35,25,-17,81,-108,-121,-72,-34,-47,23,10,31,-41,-16,71,-30,46,-97,46,76,111,64,82,-10,-34,-68,-13,-120,-16,-21,-72,31,-3,65,-82,-118,101,-64,104,-53,102,63,-126,-109,122,-86,-81,-19,12,79,-4,44,2,35,19,-16,26,69,-97,25,-36,-23,-105,-45,-67,86,22,32,60,112,-105,14,103,88,118,77,-91,6,-54,33,-57,19,-41,-2,-65,-59,-82,61,-95,44,-41,-92,117,-56,-41,113,92,18,-44,-53,-48,-68,104,-51,14,68,-86,-76,105,94,-88,99,-96,68,76,-116,-128,68,-18,0,73,-93,116,65,-14,-44,-97,-110,-2,54,47,59,95,82,-76,44,-126,125,101,38,116,-28,127,-92,47,-50,35,-24,8,18,106,-96,-68,18,-24,-127,-102,-61,-106,-108,-46,98,-12,-86,-29,-69,-106,-128,-114,-33,-94,-11,-72,74,-81,-43,79,47,-32,23,-78,55,-9,-74,22,32,-83,0,17,-17,118,-33,-78,104,-106,-7,-107,92,-15,-64,-112,-108,29,116,49,99,-6,-119,-108,-97,86,-59,-43,-74,-113,27,-115,43,-123,-29,86,71,-116,-25,-2,-27,121,77,-1,72,50,23,-78,49,54,60,122,82,-125,41,6,-31,-70,-31,9,-62,-25,-74,-71,69,93,113,-82,-47,50,27,124,82,-83,-66,100,-69,23,14,45,-63,-54,-88,-40,-27,-84,10,-10,-63,60,-60,-89,-9,-4,36,69,-77,95,3,5,-99,-116,-128,-50,67,117,-119,-116,59,-123,-14,-58,-85,-40,-32,3,47,52,73,121,-112,108,-90,-100,-110,48,124,68,85,23,-46,-85,-85,48,-68,3,0,-30,-101,-68,-81,22,-22,-127,-58,57,-82,-108,-19,-119,90,-87,39,34,-62,22,53,-61,13,-10,114,-16,29,29,91,16,88,124,-93,100,123,5,-63,-80,40,5,83,65,-118,-80,25,67,89,-103,12,-9,-1,-3,111,-33,-49,4,20,-101,-66,-47,-77,-122,53,92,4,-76,-108,-86,119,-63,33,118,18,-43,59,-84,116,-110,-106,0,82,-20,-59,50,-40,64,7,1,31,123,94,26,-22,-68,80,-128,-92,25,86,-35,-23,35,-44,52,-19,-5,61,-24,-30,94,-64,-57,-23,-100,-33,58,-58,-103,-25,4,76,112,-104,42,107,-116,57,56,41,-128,-59,36,7,-59,115,11,96,-94,12,72,-6,-14,42,2,-93,-75,73,28,109,105,-94,-67,119,61,-115,-128,-50,-32,54,108,-73,127,27,4,-78,35,-98,-26,-127,-124,-120,-64,11,-30,-20,-19,87,121,-20,59,-98,-84,67,-59,-63,14,112,75,-103,48,84,9,-64,-7,50,-107,71,98,-47,-31,-89,29,107,33,110,89,-117,-50,55,-94,-46,-57,61,79,-29,-11,-62,36,-60,-83,-29,65,46,85,-102,-126,123,31,-27,-91,31,6,-26,-90,-84,-71,33,-95,-70,111,-14,0,113,-78,-8,105,-88,48,-60,-102,107,-28,45,67,-68,124,-18,-117,11,86,127,-51,36,103,-71,70,54,-120,25,-62,117,-75,-63,49,3,-77,-44,52,36,41,-34,-64,-60,-42,58,-72,50,-79,49,41,51,116,53,-59,36,76,64,-87,-120,-32,-81,77,-119,122,70,45,-34,12,-97,117,7,-34,125,19,2,118,85,-26,-91,6,-63,47,108,-69,1,83,98,58,-95,12,115,-12,122,-86,36,80,-81,46,-90,11,87,-41,-16,22,63,-61,92,-47,1,-19,19,71,-66,-83,90,70,-120,85,-107,-94,-99,76,62,45,10,-9,20,112,73,42,63,30,120,15,110,95,75,36,14,92,-101,-51,10,62,35,-72,-119,9,67,89,-98,-15,111,126,112,-102,70,-4,-85,117,0,104,80,-19,50,-111,-2,-85,84,104,-40,-64,10,-25,-111,-82,-36,90,-7,-71,-41,-79,82,70,-56,96,-80,126,-40,-28,-38,-46,-106,61,20,-81,44,107,41,43,-52,12,-51,-4,-94,32,-39,111,-37,-77,-106,13,-87,-10,93,81,71,-124,117,-31,104,-55,-122,-48,92,123,6,70,-43,-1,-61,-109,99,70,-26,-23,-119,63,-110,-93,-81,-118,-37,-63,-28,39,2,101,126,-18,120,13,124,-86,-99,18,-40,114,-110,-85,12,76,4,22,104,88,121,120,-12,89,127,1,-23,3,20,-13,18,-49,122,117,-31,54,-119,-112,113,46,106,59,-65,-123,-28,106,-99,-53,-31,-75,77,-26,38,105,-38,121,109,-80,86,-2,82,-52,-53,-81,127,-107,79,-49,-107,-112,-88,65,-88,23,28,41,56,25,-19,55,-57,13,37,15,-99,-111,-97,-26,-97,63,101,52,46,-17,69,-87,-2,104,85,78,36,9,111,-99,-7,109,56,117,-82,94,108,-20,68,-27,-27,-22,97,-30,23,-74,-112,8,76,12,-96,-37,-61,-30,70,117,74,-34,-49,-102,-91,-63,16,40,105,46,56,-81,81,120,27,31,72,-124,-88,-101,-15,-104,35,94,-29,104,-83,-32,-86,47,103,-8,89,65,39,34,-119,-78,-108,-37,-89,-97,90,-59,107,50,51,-21,-30,60,-23,-88,-1,68,29,-6,-109,102,125,-14,-11,8,-7,43,65,82,111,12,-56,33,86,-81,-54,-82,-76,-62,122,87,-41,-83,-65,-44,127,-115,-54,108,-23,39,-22,-89,113,107,-6,83,63,-57,37,10,9,-2,22,57,-99,2,103,-40,120,100,-44,102,23,85,96,-48,-116,119,-53,-109,-40,-20,114,-21,22,-115,-71,-21,69,97,-62,-104,12,-64,-120,105,-23,-5,53,13,2,-125,45,38,-23,91,12,40,-35,66,15,10,-46,-108,-45,-42,-17,-35,113,77,-22,-47,24,-111,27,-119,27,125,-107,63,-25,30,86,-81,-72,29,-29,13,-118,-14,-92,-33,-106,88,-49,-61,14,75,35,113,-86,113,104,-2,-98,127,-72,-3,-75,26,-77,81,-69,-40,-115,-66,-15,-115,42,-83,119,16,87,-109,27,-88,106,73,121,23,40,-9,-3,-68,-37,9,114,-24,-116,-123,-60,30,-30,74,-16,-38,-43,63,118,-80,-86,0,-28,-54,44,79,41,120,33,3,46,-121,24,-124,-127,-22,33,-83,-34,97,-68,-39,3,-98,-89,76,-56,54,97,79,12,83,72,42,105,-10,33,-51,120,-95,16,-127,99,-23,53,103,89,-78,-101,-45,115,65,96,4,126,-81,-7,-87,-126,113,84,-81,-50,-69,100,-66,112,50,60,106,-119,-48,64,-110,115,-62,-119,-64,53,-88,41,-60,69,-59,-37,-116,-49,40,-52,-114,68,-76,30,91,62,-24,-36,-19,-116,-107,81,-122,123,-100,-42,6,-46,-113,90,-98,16,-72,-95,76,-11,-101,57,-60,-52,7,114,-31,47,-79,21,-103,117,-54,23,-34,-42,-57,71,-44,49,-57,2,-68,64,-82,-26,-91,-74,-13,124,50,112,28,-4,26,-84,56,109,-122,38,105,-44,-7,-87,-81,22,95,102,59,52,-80,61,-65,-14,-99,-106,-101,44,-55,-18,-20,35,-30,-36,80,58,-1,-45,110,-70,-92,-93,120,-80,112,60,-29,114,109,89,-117,51,-122,122,-76,1,38,-40,-25,94,-12,39,39,67,119,-1,-74,52,12,5,104,-84,19,-24,-19,-7,-124,41,78,55,115,59,-86,-14,-86,
    public void rewriteEncryptFileZip(String pathToFile,byte[][] b) {
        //каждый новый массив с новой строки
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i < b.length; i++) {
                for(int j = 0; j < b[i].length; j++) {
                    stringBuffer.append(b[i][j]);
                    if (j + 1 < b[i].length){
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("\r\n");
            }
            System.out.println(stringBuffer);
            fileWriter.write(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void rewriteEncryptFileZip(String pathToFile,byte[] b) {
        //каждый новый массив с новой строки
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            fileWriter.write(new String(b));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteDecryptFileZip(String pathToFile,byte[][] b) {
        int i = 0;
        try(FileOutputStream fos=new FileOutputStream(pathToFile))
        {
            // записываем из буфера в файл
            fos.write(b[i], 0, b[i].length);
            i++;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    public void rewriteDecryptFile(String pathToFile, byte[][] outputByte) {
        String str = "";
        System.out.println(new String(outputByte[0]));
        for(int i = 0; i < outputByte.length; i++) {
                str = str + new String(outputByte[i]) + "\r\n";
        }
        try (FileWriter fileWriter = new FileWriter(pathToFile)) {
            fileWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
