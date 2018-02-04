//将选中的行存入数组，并用isChecked方法在分页时进行选中项重置
        var checkedArray = [];
        var checkedTextArray = [];
        function findCheckedArray(id)
        {
            for(var i =0;i<checkedArray.length;i++)
            {
                if(checkedArray[i] == id) return i;
            }
            return -1;
        }
        function addCheckedArray(id,name)
        {
            if(findCheckedArray(id) == -1){
            	checkedArray.push(id);
            	checkedTextArray.push(name);
            }
        }
        function removeCheckedArray(id)
        {
            var i = findCheckedArray(id);
            if(i==-1) return;
            checkedArray.splice(i,1);
            checkedTextArray.splice(i,1);
        }
        function checkedHandler(rowdata)
        {
            if (findCheckedArray(rowdata.userId) == -1)
                return false;
            return true;
        }
        function checkRowHandler(checked, data)
        {
            if (checked) addCheckedArray(data.userId,data.userName);
            else removeCheckedArray(data.userId,data.userName);
        }
        function checkAllRowHandler(checked)
        {
            for (var rowid in this.records)
            {
                if(checked)
                    addCheckedArray(this.records[rowid]['userId'],this.records[rowid]['userName']);
                else
                    removeCheckedArray(this.records[rowid]['userId'],this.records[rowid]['userName']);
            }
        }