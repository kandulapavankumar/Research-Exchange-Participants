/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function updateStatus(id) {
    var c = id.value;
    if (c === 'Start') {
        id.value = 'Stop';
    } else {
        id.value = 'Start';
    }
}

function updateStudyStatus(studyCode, action) {
    document.getElementById('studyCode').value = studyCode;
    document.getElementById('editStudyForm').action = action;
    document.getElementById('editStudyForm').submit();
}

function submitForm(studyCode){
    document.getElementById('studyCode').value = studyCode;
    document.getElementById('parcipateForm').submit();
}

function submit(id){
    document.getElementById(id).submit();
}