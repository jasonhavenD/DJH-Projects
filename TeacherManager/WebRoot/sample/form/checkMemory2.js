//将选中的行存入数组，并用isChecked方法在分页时进行选中项重置
        function findCheckedArray2(id)
        {
            for(var i =0;i<checkedArray2.length;i++)
            {
                if(checkedArray2[i] == id) return i;
            }
            return -1;
        }
        function addCheckedArray2(id,name)
        {
            if(findCheckedArray2(id) == -1){
            	checkedArray2.push(id);
            	checkedTextArray2.push(name);
            }
        }
        function removeCheckedArray2(id)
        {
            var i = findCheckedArray2(id);
            if(i==-1) return;
            checkedArray2.splice(i,1);
            checkedTextArray2.splice(i,1);
        }
        function checkedHandler2(rowdata)
        {
            if (findCheckedArray2(rowdata.userId) == -1)
                return false;
            return true;
        }
        function checkRowHandler2(checked, data)
        {
            if (checked) addCheckedArray2(data.userId,data.userName);
            else removeCheckedArray2(data.userId,data.userName);
        }
        function checkAllRowHandler2(checked)
        {
            for (var rowid in this.records)
            {
                if(checked)
                    addCheckedArray2(this.records[rowid]['userId'],this.records[rowid]['userName']);
                else
                    removeCheckedArray2(this.records[rowid]['userId'],this.records[rowid]['userName']);
            }
        }